package infynicucumberautomation.base;

import java.io.File;
import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import infynicucumberautomation.utils.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	public static void launchBrowser(String browser) {

		if (browser.equals("Chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		// launchApp("https://studio.cucumber.io/users/sign_in");
		// implicitWait(4);
	}

	public static void launchApp() throws FileNotFoundException {

	//	launchBrowser("Chrome");

		String url = PropertyReader.readDataFromPropertyFile("appurl");

		driver.get(url);
		implicitWait(4);

	}

	public static void closeApp() throws IOException {
		driver.close();
		
	
	}
	
	
	public static String captureScreenshot() throws IOException {

		// Convert webdriver object to TakeScreenshot

		TakesScreenshot scrShot = (TakesScreenshot) driver;

		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

		File destinationPath = new File(
				"C://Users//prash//eclipse-workspace//cucumberautomation//Screenshots//"
						+ "ScreenCapture" + System.currentTimeMillis() + ".png");

		FileUtils.copyFile(scrFile, destinationPath);

		String filePath = destinationPath.getAbsolutePath();

		return filePath;

	}


	public static void implicitWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	public static void loadData() {
		System.out.println("Before Test: This method will run before all the test cases");
	}

	public static void closeApplication() {
		System.out.println("After Test: This method will run after all the test cases");
	}

}
