package libis.invoiceLoad.pkg;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.google.common.collect.*;
import com.google.common.collect.Table;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class HandleFiles {
	private static final String DEFAULT_OUTPUTFILENAME = "C:\\temp\\sapinvoices\\joined.xlsx";
	private String outputFileName;
	private File mF;
	private File yF;
	private int[] keysM;
	private int[] retM;
	private int[] keysY;
	private int[] retY;
	Table<String, String, Map<Integer, String>> mTable;	
	Table<String, String, Map<Integer, String>> yTable;		
	Table<String, String, Map<String, String>> jTable;
	Map<Integer, String> mFields;
	Map<Integer, String> yFields;
	
	public HandleFiles(File m, File y, String outputFilename) throws Exception {
		try {
			this.setOutputFileName(outputFilename);
			this.initM(m);
			this.initY(y);
			this.jTable = HashBasedTable.create();
			handleExcelFile(this.getMF(),this.mTable,this.keysM,this.retM,this.mFields);
			handleExcelFile(this.getYF(),this.yTable,this.keysY,this.retY,this.yFields);
			joinTables();
		} catch (Exception e) {
			throw(e);
		}
	}
	
	public HandleFiles(File m, File y) throws Exception {
		this(m, y, HandleFiles.DEFAULT_OUTPUTFILENAME);
	}
	
	private void initM (File m) {
		this.setMF(m);
		this.keysM = new int[] {1,2};
		this.retM = new int[] {1,2,3,4};
		this.mTable = HashBasedTable.create();
		this.mFields = new HashMap<Integer, String>();
		this.mFields.put(1, "Invoice");
		this.mFields.put(2, "InvoiceLine");
		this.mFields.put(3, "M-Prijs");
		this.mFields.put(4, "M-Valuta");
	}
	private void initY (File y) {
		this.setYF(y);
		this.keysY = new int[] {5,6};
		this.retY = new int[] {1,2,3,4,7,8,9};
		this.yTable = HashBasedTable.create();
		this.yFields = new HashMap<Integer, String>();
		this.yFields.put(5, "Invoice");
		this.yFields.put(6, "InvoiceLine");
		this.yFields.put(2, "Y-Bedrag FMV");
		this.yFields.put(3, "Y-Valuta");
		this.yFields.put(4, "Y-Jaar");
		this.yFields.put(7, "Y-POLine");
		this.yFields.put(8, "Y-Interne Info");
		this.yFields.put(1, "Y-Leverancier");
		this.yFields.put(9, "Y-BTWCode");		
	}
	
	public void joinTables() {
		System.out.println("Join Tables");
	    // for each row key
	    for (String key : this.mTable.rowKeySet()) {
	        for (Entry<String, Map<Integer, String>> row : this.mTable.row(key).entrySet()) {
	        	Map<String, String> cols = new HashMap<String, String>();
	        	if (yTable.contains(key, row.getKey())) {
	        		/*System.out.println("Mapping found");
		        	System.out.print(key+"-"+row.getKey()+":");*/	        	
	        		@SuppressWarnings("unused")
					int c = 1;
	        		//m-file fields
	        		for (Integer colPos : row.getValue().keySet()) {
	        		    String colValue = row.getValue().get(colPos);
		        		cols.put(this.mFields.get(colPos), colValue);
		        		c++;
	        		}
	        		c = 1;
	        		//y-file fields
	        		for (Integer colPos : this.yTable.row(key).get(row.getKey()).keySet()) {
	        		    String colValue = this.yTable.row(key).get(row.getKey()).get(colPos);
		        		cols.put(this.yFields.get(colPos), colValue);
		        		c++;
	        		}
	        		this.jTable.put(key, row.getKey(), cols);
	        	}
	        }
	    }
	}

	private static BigDecimal stringToBigDecimal(final String formattedString, final Locale locale) {
		final DecimalFormatSymbols symbols;
		final char                 groupSeparatorChar;
		final String               groupSeparator;
		final char                 decimalSeparatorChar;
		final String               decimalSeparator;
		String                     fixedString;
		final BigDecimal           number;

		symbols              = new DecimalFormatSymbols(locale);
		groupSeparatorChar   = symbols.getGroupingSeparator();
		decimalSeparatorChar = symbols.getDecimalSeparator();

		if(groupSeparatorChar == '.') {
			groupSeparator = "\\" + groupSeparatorChar;
		} else {
			groupSeparator = Character.toString(groupSeparatorChar);
		}

		if(decimalSeparatorChar == '.') {
			decimalSeparator = "\\" + decimalSeparatorChar;
		} else {
			decimalSeparator = Character.toString(decimalSeparatorChar);
		}

		fixedString = formattedString.replaceAll(groupSeparator , "");
		fixedString = fixedString.replaceAll(decimalSeparator , ".");
		number      = new BigDecimal(fixedString);

		return (number);
	}
	
	public void writeToExcel() throws IOException, InvalidFormatException {
		System.out.println("Write to excelFile");
		String[] columns = InvoiceTable.JOINED_COLUMN_NAMES;

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/* CreationHelper helps us create instances of various things like DataFormat, 
	           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Invoices");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for(int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		// Create Cell Style for formatting Numbers 
		CellStyle numberStyle = workbook.createCellStyle();
		numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("-##0.00"));
		
		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (String key : this.jTable.rowKeySet()) {
			for (Entry<String, Map<String, String>> row : this.jTable.row(key).entrySet()) {
				int c = 0;
				Row workBookRow = sheet.createRow(rowNum++);
				/* invoice and invoice line are part of joined-columns below
				workBookRow.createCell(c).setCellValue(key);
				c++;				
				workBookRow.createCell(c).setCellValue(row.getKey());
				c++;
				*/
				/*
				  style = wb.createCellStyle();
				  style.setDataFormat(format.getFormat("#.###############")); // custom number format
				  row = sheet.createRow(rowNum++);
				  cell = row.createCell(colNum);
				  cell.setCellValue(-337499.939437217);
				  cell.setCellStyle(style);
				 */
				for (String s : InvoiceTable.JOINED_COLUMN_NAMES) {
					//System.out.println("cell "+c+"("+s+"="+row.getValue().get(s));
					Cell tmpcell;
					tmpcell = workBookRow.createCell(c);

					/* POTENTIEEL INGRIJPEN OM NUMMERFORMAAT TE CORRIGEREN*/
					if (s.contentEquals("Y-Bedrag FMV") || s.contentEquals("M-Prijs")) {
						String oldS = row.getValue().get(s);
						String newS = oldS.replace(",","");
						if (!(newS.equals(oldS))) {
							//System.out.println(oldS+"->"+newS);
							tmpcell.setCellValue(newS);
							//System.out.println(Locale.getDefault());
						} else {
							tmpcell.setCellValue(oldS);							
						}
						tmpcell.setCellStyle(numberStyle);
					} else {
						tmpcell.setCellValue(row.getValue().get(s));						
					}
					c++;
				}
			}
		}
		
		// Resize all columns to fit the content size
		for(int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(this.getOutputFileName());
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}
	
	public void handleExcelFile (File f, Table<String, String, Map<Integer, String>> inTable, int[] keyPos, int[] retPos, Map<Integer, String> inFields) 
			throws Exception {
		try {
			System.out.println("Handle excel file");
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
				rowToTable(cellIterator, inTable, keyPos, retPos, inFields);
			}
			// Closing the workbook
			workbook.close();
		} catch (Exception e) {
			throw(e);
		}
	}
	
	public void rowToTable(Iterator<Cell> inCellIterator, Table<String, String, Map<Integer, String>> inTable, int[] keyPos, int[] retPos, Map<Integer, String> inFields) {
		Map<Integer, String> columnvals = new HashMap<Integer, String>();
		String[] keypair = new String[2];
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		int cellCnt = 0;
		while (inCellIterator.hasNext()) {
			cellCnt++;
			Cell cell = inCellIterator.next();
			String cellValue = dataFormatter.formatCellValue(cell);
			if (isInArray(cellCnt,keyPos)) {
				if (keyPos[0]==cellCnt) {
					keypair[0] = cellValue;
				} else {
					keypair[1] = cellValue;
				}
			}
			//only keep fields that are to be retained (retPos)
			if (isInArray(cellCnt,retPos)) {
				columnvals.put(cellCnt, cellValue);			
			}
		}
		inTable.put(keypair[0], keypair[1], columnvals);
	}

	public boolean isInArray (int i, int[] intArr) {
		boolean isIn = false;
		for (int j=0; j<intArr.length; j++) 	{
			if (intArr[j] == i) {
				isIn = true;
				break;
			}
		}	
		return(isIn);
	}
	public File getMF() {
		return mF;
	}
	public void setMF(File mF) {
		this.mF = mF;
	}
	public File getYF() {
		return yF;
	}
	public void setYF(File yF) {
		this.yF = yF;
	}
	public String getOutputFileName() {
		return outputFileName;
	}
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

}
