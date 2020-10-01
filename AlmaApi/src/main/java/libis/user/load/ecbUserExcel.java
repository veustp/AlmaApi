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

public class ecbUserExcel {
	private static final Logger LOGGER = LogManager.getLogger(UserExcel.class);
	String institution;
	List<User> userList;
	//userList.add("sup1");
	
	public ecbUserExcel (File f, String inst) {
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
				if (cellValue.equals("Primary Identifier") || cellValue.contentEquals("ID") || cellValue.contentEquals("")) {
					return;
				}
			}
			switch(colCntr) {
			case 1: //primary identifier
					u.setPrimaryId(cellValue);
					break;
			case 2: //last name
					u.setLastName(cellValue);
					break;
			case 3: //first name
					u.setFirstName(cellValue);
					break;
			case 4: //action type
					break;
			case 5: //start date
					break;
			case 6: //expiry date
					if (DateUtil.isCellDateFormatted(cell)) {
					   try {
						   	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					      	cellValue = sdf.format(cell.getDateCellValue());
//					      	System.out.println(cellValue);
//							System.out.println(cellValue.substring(0,4));
//							System.out.println(cellValue.substring(4,6));
//							System.out.println(cellValue.substring(6,8));
							int year = Integer.parseInt(cellValue.substring(0,4));
							int month = Integer.parseInt(cellValue.substring(4,6));
							int day = Integer.parseInt(cellValue.substring(6,8));
							
							u.setExpiryDate(AlmaDate.setDate(year, month, day));
							LOGGER.info("Expiry date set : "+cellValue);
					    } catch (Exception e) {
					    		LOGGER.error("Error at expirydate : "+e.getMessage());
					            e.printStackTrace();
					    }
					} else {
						LOGGER.info("Set current date as expiry date");
						u.setExpiryDate(AlmaDate.currentDate());
					}
					break;
			case 7: //campus
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
					}
					break;
			case 8: //email
					ContactInfo uci = new ContactInfo();
					Emails ues = new Emails();
					Email ue = new Email();
					ue.setEmailAddress(cellValue);
					Email.EmailTypes.EmailType et = new Email.EmailTypes.EmailType();
					et.setValue("personal");
					Email.EmailTypes ets = new Email.EmailTypes();
					ets.getEmailType().add(et);
					ue.setEmailTypes(ets);
					ue.setSegmentType("EXternal");
					ues.getEmail().add(ue);
					uci.setEmails(ues);
					u.setContactInfo(uci);
					LOGGER.info("ContactInfo "+cellValue);
					break;
			case 9: //user group
					try {
						User.UserGroup ug = new User.UserGroup();
						String userGroupCode = User.getUserGroupByDesc(inst, cellValue);
						ug.setDesc(cellValue);
						ug.setValue(userGroupCode);
						u.setUserGroup(ug);
						LOGGER.info("UserGroup : "+cellValue+"->"+userGroupCode);
					} catch (Exception e) {
						LOGGER.error("Error setting Usergroup: "+e.getMessage());
						e.printStackTrace();
					}
					break;
			}
		}
		this.userList.add(u);
	}
	
	public static void main(String[] args) {
		try (BufferedWriter writer = 
				new BufferedWriter(new FileWriter(new File("C:\\Users\\PieterDV\\Downloads\\usersECB\\usersECB.log")))) {
			String inst = "ECB_SB";
			ecbUserExcel uExcel = new ecbUserExcel(new File("C:\\Users\\PieterDV\\Downloads\\usersECB\\usersECB.xlsx"),inst);

			int cnt =  0;
			for (User usr : uExcel.userList) {
				cnt++;
				if (!usr.getPrimaryId().equals("Primary Identifier") && !usr.getPrimaryId().equals("ID")) {
					LOGGER.info("User Rcord "+cnt);
					System.out.println(cnt);
					writer.write(usr.getPrimaryId());
					writer.newLine();
					User.jaxbObjectToXML(usr);
					User u = new User();
					try {
						AlmaUserAPI userApi = new AlmaUserAPI(inst);
						u = userApi.getUser(usr.getPrimaryId());
						try {
							u.updUser(usr);
							/*System.out.println("After updUser(u)");
							User.jaxbObjectToXML(u);*/
							userApi.putUser(u);
						} catch (Exception ePut) {
							writer.write("Error main(): putUser() "+ePut.getMessage());
							writer.newLine();
							LOGGER.error("Error main(): putUser() "+ePut.getMessage());
							System.out.println("Error main(): putUser() "+ePut.getMessage());
						}
					} catch (Exception eGet) {
						writer.write("Error main(): getUser() "+eGet.getMessage());
						writer.newLine();
						LOGGER.error("Error main(): getUser() "+eGet.getMessage());
						System.out.println("Error main(): getUser() "+eGet.getMessage());
						//try to create new user
						try {
							AlmaUserAPI userApi = new AlmaUserAPI(inst);
							String pId = "";
							usr.setForcePasswordChange("true");
							pId = userApi.postUser(usr);
							LOGGER.info("Info main(): postUser(): New user record pushed to Alma : "+pId);
						} catch (Exception ePost) {
							writer.write("Error main(): postUser() "+ePost.getMessage());
							writer.newLine();
							LOGGER.error("Error main(): postUser() "+ePost.getMessage());
							System.out.println("Error main(): postUser() "+ePost.getMessage());
						}
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error main(): "+e.getMessage());
			System.out.println("Error main(): "+e.getMessage());
		}
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}