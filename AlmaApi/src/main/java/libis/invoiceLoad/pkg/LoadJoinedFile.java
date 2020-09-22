package libis.invoiceLoad.pkg;

import org.apache.logging.log4j.Logger;
import libis.alma.api.rest.AlmaInvoiceAPI;
import libis.invoice.pkg.Invoice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;

public class LoadJoinedFile {
	private static final Logger LOGGER = LogManager.getLogger(LoadJoinedFile.class);
	
	public static void main(String args[]) {
		String datum = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String errorFileName = "C:\\log\\LoadJoinedFile_"+datum+".log";
		String inputFileName = "C:\\temp\\sapinvoices\\joined_20200527.xlsx";
		try (BufferedWriter writer = 
				new BufferedWriter(new FileWriter(new File(errorFileName)))) {
			InvoiceTable iT = new InvoiceTable(new File(inputFileName));
			String inst = "KUL";
			//String inst = "KUL_SB";
			Invoice i = new Invoice();
			String invNbr = ""; //"4701630675"; //i = iT.doInvoice("4701613665"); //8 lines 4701630675
			//String invNbr = "4701629666";
			//String invNbr = "4701630493";
			for (String invKey : iT.getiTable().rowKeySet()) {
				if ((!invNbr.equals("") && invNbr.equals(invKey)) ||
				    (invNbr.equals(""))) {
					try {
						i = iT.doInvoice(invKey);
						try {
							Invoice.jaxbObjectToXML(i);
							AlmaInvoiceAPI invApi = new AlmaInvoiceAPI(inst);
							invApi.invoiceToAlma(i);
							String logtext = "Invoice Found:"+i.getId();
							LOGGER.info(logtext);
						} catch (Exception e) {
							LOGGER.error("Error Message Logged !!!"+e.getMessage());
							LOGGER.error("Error main(): "+e.getMessage());
							writer.write(iT.reCreateInvoiceLine(invKey));
							writer.newLine();					
						}
					} catch(Exception e) {
						LOGGER.error("Could not create Invoice object for "+invKey);
						LOGGER.error(e.getMessage());
						LOGGER.error(iT.reCreateInvoiceLine(invKey));
						writer.write(iT.reCreateInvoiceLine(invKey));
						writer.newLine();
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error main(): "+e.getMessage());
		}
	}
}
