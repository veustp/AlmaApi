package libis.alma.api.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class AlmaDate {
	public static XMLGregorianCalendar setDate(int year, int month, int day) {
		XMLGregorianCalendar xmlDate = null; 
		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(year, month, day, 0);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return(xmlDate);
	}
	public static XMLGregorianCalendar setDateTime(int year, int month, int day, int hour, int min, int sec) {
		XMLGregorianCalendar xmlDateTime = null;
		try {
			xmlDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(year, month, day, hour, min, sec, 0, 0); 
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return(xmlDateTime);
	}
	public static XMLGregorianCalendar currentDateTime() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.getTime();
		XMLGregorianCalendar xmlDateTime = null;
		try {
			xmlDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), 
																				cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), 
																				0, 0);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return(xmlDateTime);
	}
	public static XMLGregorianCalendar currentDate() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.getTime();
		XMLGregorianCalendar xmlDate = null;
		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), 0);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return(xmlDate);
	}
	public static XMLGregorianCalendar currentTime() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.getTime();
		XMLGregorianCalendar xmlTime = null;
		try {
			xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendarTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), 0);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return(xmlTime);
	}
	public static String almaDateToString (XMLGregorianCalendar in_date) {
		String format = "MM/dd/yyyy hh:mm:ss";
		return(AlmaDate.almaDateToString(in_date,format));
	}
	public static String almaDateToString (XMLGregorianCalendar in_date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		GregorianCalendar gc = in_date.toGregorianCalendar();
		String date = sdf.format(gc.getTime());
		return(date);
	}
	public AlmaDate() {
		// TODO Auto-generated constructor stub
	}

}
