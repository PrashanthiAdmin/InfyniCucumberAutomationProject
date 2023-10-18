package infynicucumberautomation.pageobjects;

import org.openqa.selenium.By;

import infynicucumberautomation.base.Base;



public class LoginPage extends Base {
	
	
	public static By emailIdTextBox = By.id("user_email");
	public static By passwordInputBox = By.id("user_password");
	public static By signinButton = By.name("commit");
	public static By errorMessageText = By.xpath("//p[text()='Invalid email or password.']");
	public static By allProjectsText = By.id("ember69");
	
	
	
	public static void enterEmailId(String emailAddress) {
		try {
			
			driver.findElement(emailIdTextBox).clear();
			driver.findElement(emailIdTextBox).sendKeys(emailAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void enterPassword(String password) {
		try {
			driver.findElement(passwordInputBox).clear();
			driver.findElement(passwordInputBox).sendKeys(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clickSigninButton() {
		try {
			driver.findElement(signinButton).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static boolean allProjectsTextPresence() {
		boolean result = false;
		try {
			result = driver.findElement(allProjectsText).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static String allProjectsText() {
		String value = "";
		
		try {
			value = driver.findElement(allProjectsText).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
	
	public static boolean errorMessagePresence() {
		
		boolean result = false;
		try {
			result = driver.findElement(errorMessageText).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	

}
