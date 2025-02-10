package genericUtility;

import java.util.Date;
import java.util.Random;

import org.testng.Reporter;

/**
 * this class is used to use the java utility file
 */
public class JavaUtility {

	/**
	 * this method is used random number
	 * 
	 * @return
	 */
	public int toGetRandom() {
		Random r = new Random();
		int randomnumber = r.nextInt(100);
		return randomnumber;
	}

	/**
	 * this method is used for completeDateFormat
	 * 
	 * @return
	 */
	public String toGetSystemDateAndTime() {

		Date d = new Date();
		String[] date = d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];

		String completeDateFormat = day + " " + month + " " + date1 + " " + time + " " + year;
		return completeDateFormat;
	}

}
