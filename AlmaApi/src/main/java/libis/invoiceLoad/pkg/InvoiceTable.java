package libis.invoiceLoad.pkg;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DateUtil;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import libis.invoice.pkg.FundDistribution;
import libis.invoice.pkg.FundDistributions;
import libis.invoice.pkg.Invoice;
import libis.invoice.pkg.InvoiceLine;
import libis.invoice.pkg.InvoiceLineVat;
import libis.invoice.pkg.InvoiceVat;
import libis.alma.api.rest.AlmaDate;
import libis.alma.api.rest.AlmaInvoiceAPI;
import libis.invoice.pkg.Payment;
import libis.invoice.pkg.Payment.PaymentStatus;

public class InvoiceTable {
	private static final Logger LOGGER = LogManager.getLogger(InvoiceTable.class);
	public final static String[] JOINED_COLUMN_KEYS = new String[] {"Invoice","InvoiceLine"};
	public final static String[] JOINED_COLUMN_NAMES = (String[]) ArrayUtils.addAll(JOINED_COLUMN_KEYS, new String[] {
			"M-Prijs","M-Valuta",
			"Y-Bedrag FMV","Y-Valuta","Y-Jaar","Y-POLine","Y-Leverancier","Y-Interne Info","Y-BTWCode"});

	private Table<String, String, Map<String, String>> iTable;

	public Table<String, String, Map<String, String>> getiTable() {
		return this.iTable;
	}

	public InvoiceTable (File f) {
		this.iTable = HashBasedTable.create();
		try {
			this.excelToInvoiceTable(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excelToInvoiceTable(File f) 
			throws Exception {
		try {
			LOGGER.info("Read Invoice file");
			// Creating a Workbook from an Excel file (.xls or .xlsx)
			Workbook workbook = WorkbookFactory.create(f);
			// Getting the Sheet at index zero
			//Sheet sheet = workbook.getSheet("maandtotalen2018");
			Sheet sheet = workbook.getSheetAt(0);

			// 1. You can obtain a rowIterator and columnIterator and iterate over them
			Iterator<Row> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Now let's iterate over the columns of the current row
				Iterator<Cell> cellIterator = row.cellIterator();
				rowToInvoiceTable(cellIterator);
			}
			// Closing the workbook
			workbook.close();
		} catch(Exception e) {
			throw(e);
		}
	}
	
	public void rowToInvoiceTable(Iterator<Cell> inCellIterator) {
		// Create a DataFormatter to format and get each cell's value as String
		//populate iTable
		DataFormatter dataFormatter = new DataFormatter();
		String[] keypair = new String[2];
		Map<String, String> cols = new HashMap<String, String>();
		
		int cellCnt = 0;
		int colPos = 0;
		while (inCellIterator.hasNext()) {
			cellCnt++;
			colPos = cellCnt - 1;
			Cell cell = inCellIterator.next();
			String cellValue = dataFormatter.formatCellValue(cell);
			//handle key fields (2)
			if (colPos < JOINED_COLUMN_KEYS.length) {
				keypair[colPos] = cellValue;
			} else {
				//colPos  > JOINED_COLUMN_KEYS.length
				if (colPos < JOINED_COLUMN_NAMES.length) {
					cols.put(JOINED_COLUMN_NAMES[colPos], cellValue);
				}
			}
		}
		/*System.out.print("keys("+keypair[0]+","+keypair[1]+")->");
		for (String s: cols.keySet()) {
			System.out.print(s+":"+cols.get(s)+";");
		}
		System.out.println();*/
		//System.out.println("keys("+keypair[0]+","+keypair[1]+")");
		this.iTable.put(keypair[0], keypair[1], cols);
	}

	public String reCreateInvoiceLine(String i) {
		try {
			String lineSeperator=System.getProperties().getProperty("line.separator");
			String sep 		= "|";
			String csvLine 	= "";
			Map<String, Map<String, String>> iTab = new HashMap<String,Map<String,String>>();
			//"Invoice","InvoiceLine",
			//"M-Leverancier","M-Prijs","M-Valuta",
			//"Y-Bedrag FMV","Y-Valuta","Y-Jaar","Y-POLine","Y-Levervancier","Y-Interne Info","Y-BTWCode"});
			iTab = this.iTable.row(i);
			int countLines = 0;
			for (String il : iTab.keySet()) {
				countLines++;
				LOGGER.info(countLines+":"+i+","+il);
				Map<String, String> invMap = new HashMap<String,String>();
				csvLine = i+sep+il;
				invMap = iTab.get(il);
				int colPos = JOINED_COLUMN_KEYS.length;
				while (colPos < JOINED_COLUMN_NAMES.length) {
					LOGGER.debug(colPos+sep+JOINED_COLUMN_NAMES[colPos]+sep+invMap.get(JOINED_COLUMN_NAMES[colPos]));
					csvLine = csvLine + sep + invMap.get(JOINED_COLUMN_NAMES[colPos]);
					colPos++;
				}
				csvLine = csvLine+lineSeperator;
			}
			return(csvLine);
		} catch(Exception e) {
			LOGGER.error("Could not ReCreate the invoiceLine : "+i);
			LOGGER.error(e.getMessage()+","+e.getStackTrace());
			return(i+"|");			
		}	
	}	
	
	public Invoice doInvoice(String i) throws Exception { 
		try {
			Invoice invoice = new Invoice();
			Map<String, Map<String, String>> iTab = new HashMap<String,Map<String,String>>();
			//"Invoice","InvoiceLine",
			//"M-Leverancier","M-Prijs","M-Valuta",
			//"Y-Bedrag FMV","Y-Valuta","Y-Jaar","Y-POLine","Y-Levervancier","Y-Interne Info","Y-BTWCode"});
			iTab = this.iTable.row(i);
			int countLines = 0;
			for (String il : iTab.keySet()) {
				countLines++;
				LOGGER.info(countLines+":"+i+","+il);
				Map<String, String> invMap = new HashMap<String,String>(); 
				invMap = iTab.get(il);
				if (countLines==1) {
					LOGGER.info("Initialize invoice object");
					LOGGER.info("Leverancier:"+invMap.get("Y-Leverancier"));
					//invoice object
					invoice.setNumber(i);

 					//Do not set VAT
 					InvoiceVat.Type ivt = new InvoiceVat.Type();
					InvoiceVat iv 		= new InvoiceVat();
					//change 20190425 op vraag van GN van false naar true
					// set percentage ook weg
					/* 20190524
					InvoiceVat.VatCode vCode = new InvoiceVat.VatCode();
					vCode.setValue("21");
					iv.setVatCode(vCode);
					iv.setPercentage(new BigDecimal(Invoice.VATCodeToPercentage(invMap.get("Y-BTWCode"))));
					*/
					//expendedfromfund -> true (ipv false)
					iv.setVatPerInvoiceLine(true);
					iv.setExpendedFromFund(true);
					ivt.setValue("INCLUSIVE");
					iv.setType(ivt);
					invoice.setInvoiceVat(iv); //20190524 -- terug aangezet op 20190604
					
					//Payment ???20190925
					/*
					Payment p = new Payment();
					PaymentStatus ps = new Payment.PaymentStatus();
					ps.setValue('PAID');
					p.setPaymentStatus(ps);
					invoice.setPayment(p);
					*/
					
					Invoice.Vendor vendor = new Invoice.Vendor();
					vendor.setValue(invMap.get("Y-Leverancier"));
					invoice.setVendor(vendor);
					invoice.setTotalAmount(new BigDecimal(100d));
					invoice.setInvoiceDate(AlmaDate.currentDate());
					Invoice.Currency ic = new Invoice.Currency();
					ic.setValue(invMap.get("Y-Valuta"));
					invoice.setCurrency(ic);
					//invoice.setNumber(invMap.get("Invoice"));
					Invoice.PaymentMethod ip = new Invoice.PaymentMethod();
					ip.setValue("ACCOUNTINGDEPARTMENT");
					invoice.setPaymentMethod(ip);
					//Invoice.jaxbObjectToXML(invoice);
				}
				invoice.addInvoiceLine(this.addInvoiceLine(i,il));
			}
			BigDecimal totalAmount = new BigDecimal(0);
			BigDecimal result = new BigDecimal(0);
			for (InvoiceLine il : invoice.getInvoiceLines()) {
				result = totalAmount.add(il.getPrice());
				totalAmount = result;
			}
			invoice.setTotalAmount(totalAmount);
			Invoice.NumberOfLines nol = new Invoice.NumberOfLines();
			nol.setValue(countLines);
			invoice.setNumberOfLines(nol);
			return(invoice);
		} catch (Exception e) {
			String eMsg = "Could not create an Invoice Object : "+i; 
			LOGGER.error(eMsg);
			LOGGER.error(e.getMessage()+","+e.getStackTrace());
			throw(new Exception(eMsg));
		}
}
	
	public InvoiceLine addInvoiceLine(String i, String il) throws Exception {
		try {
			InvoiceLine invoiceLine = new InvoiceLine();
			System.out.println(i+","+il);
			Map<String, String> invMap = new HashMap<String,String>();
			invMap = this.iTable.row(i).get(il);
			//"Invoice","InvoiceLine",
			//"M-Leverancier","M-Prijs","M-Valuta",
			//"Y-Bedrag FMV","Y-Valuta","Y-Jaar","Y-POLine","Y-Levervancier","Y-Interne Info","Y-BTWCode"});
			System.out.println("Add line "+il);
	    	InvoiceLine.Type t = new InvoiceLine.Type();
	    	t.setValue("REGULAR");
	    	invoiceLine.setType(t);			
			invoiceLine.setNumber(il);
			BigDecimal ilp = new BigDecimal(invMap.get("Y-Bedrag FMV"));
			BigDecimal minIlp = ilp.multiply(new BigDecimal(-1)); //take care of the - sign
			invoiceLine.setPrice(minIlp); //ipv M-Prijs 20190604
			//invoiceLine.setTotalPrice(new BigDecimal(invMap.get("Y-Bedrag FMV"))); //ipv M-Prijs 20190604
			invoiceLine.setTotalPrice(minIlp); //ipv M-Prijs 20190604
			invoiceLine.setPoLine(invMap.get("Y-POLine"));
			//invoiceLine.setPoLine("1234567"+il);
			String addInfo = "";
			if (!invMap.get("Y-Interne Info").equals("")) {
				addInfo = addInfo+invMap.get("Y-Interne Info");
			}
			if (!invMap.get("Y-Jaar").equals("") && 
					!invMap.get("Y-Jaar").equals(addInfo)) {
				if (!addInfo.equals("")) { 
					addInfo = addInfo+",";
				}
				addInfo = addInfo+invMap.get("Y-Jaar");
			}
			if (!addInfo.equals("")) {
				invoiceLine.setAdditionalInfo(addInfo);
			}
			int jaar = 0;
			String currentYear = AlmaDate.almaDateToString(AlmaDate.currentDate(),"yyyy");
			int addInfoJaar = -1;
			if (!invMap.get("Y-Interne Info").equals("")) {
				try{
					  addInfoJaar = Integer.parseInt(invMap.get("Y-Interne Info"));
					} catch (NumberFormatException e) {
					  addInfoJaar = -1;
  					  LOGGER.info("AddInfo does not contain a valid year "+invMap.get("Y-Interne Info"));					  
					}
			}
			if (addInfoJaar != -1) {
				jaar = addInfoJaar;
			} else {
				if (!invMap.get("Y-Jaar").equals("")) {
					try {
						jaar = Integer.parseInt(invMap.get("Y-jaar"));
						
					} catch (Exception e) {
						jaar = Integer.parseInt(currentYear);
					}
				} else {
					jaar = Integer.parseInt(currentYear);
				}
			}
			XMLGregorianCalendar fromDate = AlmaDate.setDate(jaar, 1, 1);
			XMLGregorianCalendar toDate = AlmaDate.setDate(jaar, 12, 31);
			invoiceLine.setSubscriptionFromDate(fromDate);
			invoiceLine.setSubscriptionToDate(toDate);
			invoiceLine.setNote(invMap.get("M-Prijs")+" "+invMap.get("M-Valuta"));
			
			InvoiceLineVat ilv = new InvoiceLineVat();
			ilv.setPercentage(BigDecimal.valueOf(Invoice.VATCodeToPercentage(invMap.get("Y-BTWCode"))));
			String amt = invMap.get("Y-Bedrag FMV");
			//double btw = Double.parseDouble(amt) * Invoice.VATCodeToPercentage(invMap.get("Y-BTWCode")) / 100d;
			double btwPercentage = (Invoice.VATCodeToPercentage(invMap.get("Y-BTWCode")) / 100d);
			double btw = -1d * Double.parseDouble(amt) * (btwPercentage / (1 + btwPercentage));
		    BigDecimal bd = new BigDecimal(btw);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
			ilv.setVatAmount(bd);

			//ilv.setVatAmount(new BigDecimal(0));
//			InvoiceVat.VatCode vCode = new InvoiceVat.VatCode();
//			vCode.setValue("21");
			// vraag van GN 20190426: vatcode + fund toegevoegd op lijnniveau
			InvoiceLineVat.VatCode ivCode = new InvoiceLineVat.VatCode();
			ivCode.setValue("21");
			ilv.setVatCode(ivCode);
			invoiceLine.setInvoiceLineVat(ilv);
			FundDistribution.FundCode fCode = new FundDistribution.FundCode();
			//fCode.setValue("KUL-ALG"); //KUL-ALG //20150924
			FundDistribution ivlFundD = new FundDistribution();
			//ivlFundD.setFundCode(fCode); //20190524
			ivlFundD.setPercent(new BigDecimal(100));
			//ivlFundD.setAmount(new BigDecimal(invMap.get("M-Prijs"))); //20190524
			FundDistributions ivlFundDs = new FundDistributions();
			ivlFundDs.getFundDistribution().add(ivlFundD);
			//invoiceLine.setFundDistributions(ivlFundDs); //20190524
			
			invoiceLine.setQuantity(1);
			return(invoiceLine);
			//InvoiceLine.jaxbObjectToXML(invoiceLine);
		} catch (Exception e) {
			String eMsg = "Could not generate an InvoiceLine object : "+i+","+il;
			LOGGER.error(eMsg);
			LOGGER.error(e.getMessage()+","+e.getStackTrace());
			throw(new Exception(eMsg));
		}
	}
	
	
	public void handleInvoiceTable() {
		@SuppressWarnings("unused")
		String currInvoice = "";
		for (String key : this.iTable.rowKeySet()) { //key == invoice nbr
			String inst = "KUL_SB";
			try {
				Invoice i = new Invoice();
				i = this.doInvoice(key);
				try {
					Invoice.jaxbObjectToXML(i);
					AlmaInvoiceAPI invApi = new AlmaInvoiceAPI(inst);
					invApi.invoiceToAlma(i);
					LOGGER.info("Invoice Loaded ("+key+"):"+i.getId()+"\n");
				} catch (Exception e) {
					LOGGER.error("Error Loading Invoice("+key+"): "+e.getMessage());
				}
			} catch (Exception e) {
				LOGGER.info("No invoice created for "+key);				
			}				
			/*
			for (@SuppressWarnings("unused") Entry<String, Map<String, String>> row : this.iTable.row(key).entrySet()) {
				System.out.println("Invoice "+key+", line "+row.getKey());
				for (@SuppressWarnings("unused") String s : JOINED_COLUMN_NAMES) {
					System.out.println(s+":"+row.getValue().get(s));
				}
			}
			*/
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvoiceTable iT = new InvoiceTable(new File("C:\\temp\\sapinvoices\\joined_20190423.xlsx"));
		//HANDLE ENTIRE FILE 
		//iT.handleInvoiceTable();
		//iT.doInvoice("4701613665","10");
		String inst = "KUL_SB";
		//String inst = "KUL";
		//HANDLE ONLY ONE INVOICE -- uncomment below section
		
		Invoice i = new Invoice();
		try {
			//i = iT.doInvoice("4701613788");
			i = iT.doInvoice("4701629666"); //8 lines
		} catch (Exception e) {
			System.out.println("Error");
		}
		if (i != null) {
			try {
				Invoice.jaxbObjectToXML(i);
				AlmaInvoiceAPI invApi = new AlmaInvoiceAPI(inst);
				invApi.invoiceToAlma(i);
				System.out.println("Invoice Found:"+i.getId()+"\n");
			} catch (Exception e) {
				System.out.println("Error main(): "+e.getMessage());
			}
		} else {
			System.out.println("No invoice created");
		}
		//END HANDLE ONLY ONE
	}

}
