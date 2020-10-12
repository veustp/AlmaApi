package libis.user.load;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DateUtil;

import libis.alma.api.rest.AlmaDate;
import libis.alma.api.rest.AlmaUserAPI;
import libis.user.pkg.*;


public class EcbUpdCampus {

	private static final Logger LOGGER = LogManager.getLogger(EcbUpdCampus.class);
	String institution;
	List<User> userList;
	//userList.add("sup1");
	
	public EcbUpdCampus (File f, String inst) {
		this.userList = new ArrayList<User>();
		this.institution = inst;
		try {
			this.excelToUserList(f,inst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void excelToUserList(File f, String inst) throws Exception {
		try {
			System.out.println("Read User file");
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
				rowToUserList(cellIterator,inst);
			}
			// Closing the workbook
			workbook.close();
		} catch(Exception e) {
			LOGGER.error(e.getMessage());
			throw(e);
		}
	}

	public void rowToUserList(Iterator<Cell> inCellIterator, String inst) {
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();		

		boolean AddUser = true;
		User u = new User();
		User.AccountType uat = new User.AccountType();
		uat.setValue("INTERNAL");
		uat.setDesc("Internal");
		u.setAccountType(uat);
		User.RecordType urt = new User.RecordType();
		urt.setValue("PUBLIC");
		urt.setDesc("Public");
		u.setRecordType(urt);
		User.Status us = new User.Status();
		us.setValue("ACTIVE");
		u.setStatus(us);
		User.PreferredLanguage upl = new User.PreferredLanguage(); 
		u.setPreferredLanguage(upl);
		
		int colCntr = 0;
		while (inCellIterator.hasNext()) {
			colCntr++;
			Cell cell = inCellIterator.next();
			String cellValue = dataFormatter.formatCellValue(cell);
			if (colCntr == 1) {
				System.out.println(cellValue);
				LOGGER.info("1st column value "+cellValue);
				if (cellValue.equals("Pers.No.") || cellValue.contentEquals("ID") || cellValue.contentEquals("")) {
					return;
				}
			}
			switch(colCntr) {
			case 1: //primary identifier
					u.setPrimaryId(cellValue);
					break;
			case 2: //last name
					break;
			case 3: //first name
					break;
			case 4: //action type
					break;
			case 5: //start date
					break;
			case 6: //campus
					try {
						User.CampusCode uc = new User.CampusCode();
						String campusCode = User.getCampusCodeByDesc(inst, cellValue);
						uc.setDesc(cellValue);
						uc.setValue(campusCode);
						u.setCampusCode(uc);
						LOGGER.info("CampusCode : "+cellValue+"->"+campusCode);
					} catch (Exception e) {
						LOGGER.error("Error setting Campuscode: "+e.getMessage());
						e.printStackTrace();
						AddUser = false;
					}
					break;
			case 8: //user group
					break;
			}
		}
		if (AddUser) {
			if (u.getCampusCode().getValue().contentEquals("")) {
				LOGGER.error("No CampusCode found for "+u.getPrimaryId());
			} else {
				this.userList.add(u);
			}
		}
	}
	
	public static void main(String[] args) {
		try (BufferedWriter writer = 
				new BufferedWriter(new FileWriter(new File("C:\\temp\\UpdCampusCode\\ObsCampusCodes.log")))) {
			String inst = "ECB";
			EcbUpdCampus uExcel = new EcbUpdCampus(new File("C:\\temp\\UpdCampusCode\\ObsCampusCodes.xlsx"),inst);

			int cnt =  0;
			for (User usr : uExcel.userList) {
				cnt++;
				if (!usr.getPrimaryId().equals("Pers.No.") && !usr.getPrimaryId().equals("ID")) {
					LOGGER.info("User Rcord "+cnt);
					//System.out.println(cnt);
					//User.jaxbObjectToXML(usr);
					User u = new User();
					try {
						AlmaUserAPI userApi = new AlmaUserAPI(inst);
						u = userApi.getUser(usr.getPrimaryId());
						try {
							u.setCampusCode(usr.getCampusCode());
							User.jaxbObjectToXML(usr);
							User.jaxbObjectToXML(u);
							if (u.getAccountType().getValue().equals("INTERNAL") &&
							    !u.getExternalId().equals("")) {
							    	u.setExternalId("");
							    	LOGGER.info("Emptied External Id for Internal User "+u.getPrimaryId());
							    }
							userApi.putUser(u);
							writer.write("OK|"+usr.getPrimaryId()+"|"+usr.getCampusCode().getValue()+"|"+usr.getCampusCode().getDesc());
							writer.newLine();
						} catch (NullPointerException eNP) { 
							LOGGER.error("Error main(): putUser() "+u.getPrimaryId()+";"+eNP.toString());//ePut.getMessage());
							System.out.println("Error main(): putUser() "+u.getPrimaryId()+";"+eNP.toString());//ePut.getMessage());
							writer.write("NOK|"+usr.getPrimaryId()+"|"+usr.getCampusCode().getValue()+"|"+usr.getCampusCode().getDesc());
							writer.newLine();
						} catch (Exception ePut) {
							LOGGER.error("Error main(): putUser() "+u.getPrimaryId()+";"+ePut.toString());//ePut.getMessage());
							System.out.println("Error main(): putUser() "+u.getPrimaryId()+";"+ePut.toString());//ePut.getMessage());
							writer.write("NOK|"+usr.getPrimaryId()+"|"+usr.getCampusCode().getValue()+"|"+usr.getCampusCode().getDesc());
							writer.newLine();
						}
					} catch (Exception eGet) {
						LOGGER.error("Error main(): getUser() "+eGet.toString());//getMessage());
						writer.write("NOK|"+usr.getPrimaryId()+"|"+usr.getCampusCode().getValue()+"|"+usr.getCampusCode().getDesc());
						writer.newLine();
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error main(): "+e.toString());//getMessage());
			System.out.println("Error main(): "+e.toString());//getMessage());
		}
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}