package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is consist of the logic related xl file
 */
public class XlFileUtility {
	/**
	 * this method is used to read data from xl file by provideing the sheetname
	 * ,row and cell
	 * 
	 * @param Sheetname
	 * @param index
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String toReadDataFromXlFile(String Sheetname, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream fisx = new FileInputStream(IconstantUtility.xlfileutility);

		Workbook wb = WorkbookFactory.create(fisx);
		String xlData = wb.getSheet(Sheetname).getRow(row).getCell(cell).toString();

		return xlData;

	}
}
