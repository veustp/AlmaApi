package libis.invoiceLoad.pkg;

import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import libis.alma.api.rest.AlmaDate;

public class JoinFilesApp {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		try {
			//FilePicker fp = new FilePicker();
			File m = new File ("C:\\temp\\sapinvoices\\ME80FN20192020.XLSX");
			File y = new File ("C:\\temp\\sapinvoices\\YFR01220192020.xlsx");
			String fileName = "C:\\temp\\sapinvoices\\joined_"+AlmaDate.almaDateToString(AlmaDate.currentDate(), "yyyyMMdd")+".xlsx";
			HandleFiles hf = new HandleFiles(m, y, fileName);
			hf.writeToExcel();
			System.out.println("done : "+hf.getOutputFileName());
		} catch (Exception e) {
			System.out.println("Erorr : "+e.getMessage());
		}
	}

}
