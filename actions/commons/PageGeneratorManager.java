package commons;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static pageObjects.HomePageObject getHomePage(WebDriver driver) {
		return new pageObjects.HomePageObject(driver);
	}
	
	public static pageObjects.LoginPageObject getLoginPage(WebDriver driver) {
		return new pageObjects.LoginPageObject(driver);
	}
	
	public static pageObjects.RegisterPageObject getRegisterPage(WebDriver driver) {
		return new pageObjects.RegisterPageObject(driver);
	}
	
	public static pageObjects.CustomerPageObject getCustomerPage(WebDriver driver) {
		return new pageObjects.CustomerPageObject(driver);
	}
}
