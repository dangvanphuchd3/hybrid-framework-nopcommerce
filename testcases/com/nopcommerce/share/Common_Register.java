package com.nopcommerce.share;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Common_Register extends BaseTest {
	 private WebDriver driver;
	 private HomePageObject homePage;
	 private RegisterPageObject registerPage;
	 
	 public static String firstName, lastName, emailAddress, password;

	 @Parameters("browser")
	 @BeforeTest
	 public void beforeClass(String browserName) {
		 driver = getBrowserDriver(browserName);

		 homePage = PageGeneratorManager.getHomePage(driver);
		 
		 emailAddress = getEmailAddress();
		 password = "123456";
		 firstName = "John";
		 lastName = "Kennedy";

		 registerPage = homePage.clickToRegisterLink();

		 registerPage.enterToFirstNameTextbox(firstName);
		 registerPage.enterToLastNameTextbox(lastName);
		 registerPage.enterToEmailTextbox(emailAddress);
		 registerPage.enterToPasswordTextbox(password);
		 registerPage.enterToConfirmPasswordTextbox(password);

		 registerPage.clickToRegisterButton();

		 Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		 
		 System.out.println("Email at Common = " + emailAddress);
		 System.out.println("Password at Common = " + password);
		 
		 driver.quit();

	 }
}
