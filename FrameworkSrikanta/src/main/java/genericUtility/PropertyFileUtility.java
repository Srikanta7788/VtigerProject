package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consist of the logic related to property file
 */
public class PropertyFileUtility {
	/**
	 * this method is used to read the data from property file by provide the key
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String toReadDataFromPropertyFile(String key) throws IOException {

		FileInputStream fis = new FileInputStream(IconstantUtility.propertfileutility);
		Properties pr = new Properties();
		pr.load(fis);
		String value = pr.getProperty(key);

		return value;

	}
}
