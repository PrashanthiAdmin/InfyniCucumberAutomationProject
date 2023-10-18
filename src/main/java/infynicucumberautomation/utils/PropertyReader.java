package infynicucumberautomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String readDataFromPropertyFile(String key) throws FileNotFoundException {

		FileInputStream fs = new FileInputStream(
				"C:\\Users\\prash\\eclipse-workspace\\cucumberautomation\\appconfig.properties");

		Properties prop = new Properties();
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String data = prop.getProperty(key);

		return data;

	}

}
