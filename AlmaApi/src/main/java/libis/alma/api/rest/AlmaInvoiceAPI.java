package libis.alma.api.rest;

import java.io.StringReader;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import libis.invoice.pkg.Invoice;
import libis.invoice.pkg.InvoiceLine;

public class AlmaInvoiceAPI {
	private static final Logger LOGGER = LogManager.getLogger(AlmaInvoiceAPI.class);	
	private AlmaAcqAPIClient almaAPIClient;
	public AlmaAcqAPIClient getAlmaAPIClient() {
		return almaAPIClient;
	}
	public void setAlmaAPIClient(AlmaAcqAPIClient almaAPIClient) {
		this.almaAPIClient = almaAPIClient;
	}
	public AlmaInvoiceAPI(String inst) throws Exception {
		try {
			this.setAlmaAPIClient(new AlmaAcqAPIClient(inst));
		} catch (Exception e) {
			throw e;
		}
	}
	private Invoice responseToInvoice(Response resp) throws Exception {
		try {
			JAXBContext jaxbContext;			
			jaxbContext = JAXBContext.newInstance(Invoice.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(resp.readEntity(String.class));
			Invoice i = (Invoice) unmarshaller.unmarshal(reader);
			return(i);
		} catch (JAXBException e) {
			throw new Exception("Error reading Invoice Response Object from API ("+e.getMessage()+")");
		}
	}
	private InvoiceLine responseToInvoiceLine(Response resp) throws Exception {
		try {
			JAXBContext jaxbContext;			
			jaxbContext = JAXBContext.newInstance(InvoiceLine.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(resp.readEntity(String.class));
			InvoiceLine il = (InvoiceLine) unmarshaller.unmarshal(reader);
			return(il);
		} catch (JAXBException e) {
			throw new Exception("Error reading Invoice Line Response Object from API("+e.getMessage()+")");
		}
	}
	public void getInv(String id) throws Exception{
		try {
			String view = null;
			Response resp = null;
			resp = this.getAlmaAPIClient().getAlmaApi().getInvoicesinvoice_id(id,view);
			if (resp.getStatus() == 200) {
				getInvResponse(resp);
			} else {
				this.getAlmaAPIClient().handleError(resp);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	public String postInv(Invoice i) throws Exception {
		try {
			String id = "";
			Response resp = null;
			resp = this.getAlmaAPIClient().getAlmaApi().postInvoices(i);
			AlmaAcqAPIClient.responseToString(resp);
			if (resp.getStatus() == 200) {
				id = postInvResponse(resp);
			} else {
				this.getAlmaAPIClient().handleError(resp);
			}
			return(id);
		} catch (Exception e) {
			throw e;
		}
	}
	public void postInvLine(String invoiceId, InvoiceLine invLine) throws Exception{
		try {
			Response resp = null;
			resp = this.getAlmaAPIClient().getAlmaApi().postInvoicesinvoice_idlines(invoiceId, invLine);
			if (resp.getStatus() == 200) {
				postInvLineResponse(resp);
			} else {
				this.getAlmaAPIClient().handleError(resp);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	public void processInv(String id) throws Exception {
		try {
			Invoice i = new Invoice();
			i.setId(id);
			Response resp = null;
			resp = this.getAlmaAPIClient().getAlmaApi().postInvoicesinvoice_id(i, id, "process_invoice");
			AlmaAcqAPIClient.responseToString(resp);
			if (resp.getStatus() == 200) {
				processInvResponse(resp);
			} else {
				this.getAlmaAPIClient().handleError(resp);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	private void getInvResponse(Response resp) throws Exception{
		try {
			Invoice i = this.responseToInvoice(resp);
			LOGGER.debug(i.getInvoiceStatus().getDesc());
			LOGGER.debug(i.getNumberOfLines().getValue());
			LOGGER.debug(i.getInvoiceLines().size());
			for (InvoiceLine il : i.getInvoiceLines()) {
				LOGGER.debug(il.getId());
				LOGGER.debug(il.getNumber());
				LOGGER.debug(il.getPoLine());
			}
		} catch (Exception e) {
			throw(e);
		}
	}
	public String postInvResponse(Response resp) throws Exception{
		try {
			Invoice i = this.responseToInvoice(resp);
			return(i.getId());
		} catch (Exception e) {
			throw e;
		}
	}
	public void postInvLineResponse(Response resp) throws Exception {
		try {
			InvoiceLine il = this.responseToInvoiceLine(resp);
			LOGGER.debug(il.getId());
			LOGGER.debug(il.getAdditionalInfo());
			LOGGER.debug(il.getNote());
			LOGGER.debug(il.getPoLine());
			LOGGER.debug(il.getQuantity());
		} catch (Exception e) {
			throw e;
		}
	}
	public void processInvResponse(Response resp) throws Exception {
		try {
			Invoice i = this.responseToInvoice(resp);
			LOGGER.debug(i.getId());
			LOGGER.debug(i.getInvoiceStatus().getDesc());
		} catch (Exception e) {
			throw e;
		}
	}

	public void invoiceToAlma(Invoice i) throws Exception {
		try {
			String id =  "";
			Invoice iWithoutLines = i.copyWithoutInvoiceLines(i);
			LOGGER.info("Sending Invoice Object:\n"+
							   iWithoutLines.invXML());
			id = this.postInv(iWithoutLines);
			if (!id.equals("")) {
				LOGGER.info("Invoice id returned:" +id);
				for (InvoiceLine il : i.getInvoiceLines()) {
					try {
						LOGGER.info("Post Invoice, line : "+i.getNumber()+","+il.getNumber()+"\n"+
								il.invLineXML());
						this.postInvLine(id, il);
					} catch (Exception e) {
						LOGGER.error("Error Post Invoice, line : "+i.getNumber()+","+il.getNumber()+"\n"+
								il.invLineXML());
						LOGGER.error(e.getMessage());
						LOGGER.error("InvoiceLine skipped...");
						throw(e);
					}
				}
				LOGGER.info("Process Inoice");
				this.processInv(id);
				LOGGER.info("Invoice complete");
			}
		} catch (Exception e) {
			throw new Exception("Error invoiceToAlma(): \n"+
								"invNumber="+i.getNumber()+"\n"+
								e.getMessage()+"\n");
		}
	}
}