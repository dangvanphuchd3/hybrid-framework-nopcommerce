package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_17_ReportNG extends BaseTest {
	 private WebDriver driver;
	 private HomePageObject homePage;
	 private RegisterPageObject registerPage;
	 private LoginPageObject loginPage;
	 private String emailAddress = getEmailAddress();
	 String firstName, lastName;
	 
	 @Parameters({"browser"})
	 @BeforeClass
	 public void beforeClass(String browserName) {
		 driver = getBrowserDriver(browserName);
		 homePage = PageGeneratorManager.getHomePage(driver);
		 
		 firstName = "John";
		 lastName = "Wick";
	 }

	 @Test
	 public void User_01_Register_Validate() {
		 log.info("Register - Step 01: Verify Register link is displayed");
		 verifyFalse(homePage.isRegisterLinkDisplayed());
		 
		 log.info("Register - Step 02: Click To Register Link");
		 registerPage = homePage.clickToRegisterLink();
		 
		 log.info("Register - Step 03: Click Register Button");
		 registerPage.clickToRegisterButton();
		 
		 log.info("Register - Step 04: Verify error message at 'FirtName' Textbox is 'First name is required.'");
		 verifyEquals(registerPage.getFirtNameErrorMessage(), "First name is required");
		 
		 log.info("Register - Step 05: Verify error message at 'Email' Textbox is 'Email is required.'");
		 verifyEquals(registerPage.getEmailErrorMessage(),"Email is required.");
	 }
	 
	 @Test
	 public void User_02_Register_Success() {
		 log.info("Register - Step 01: Enter to 'FirstName' Textbox is " + firstName);
		 registerPage.refreshCurrentPage(driver);
		 registerPage.enterToFirstNameTextbox(firstName);
		 
		 log.info("Register - Step 02: Enter to 'LastName' Textbox is " + lastName);
		 registerPage.enterToLastNameTextbox(lastName);
		 
		 log.info("Register - Step 03: Enter to 'Email' Textbox is " + emailAddress);
		 registerPage.enterToEmailTextbox(emailAddress);
		 
		 log.info("Register - Step 04: Enter to 'Password' Textbox");
		 registerPage.enterToPasswordTextbox("123456");
		 
		 log.info("Register - Step 05: Enter to 'ConfirmPassword' Textbox");
		 registerPage.enterToConfirmPasswordTextbox("123456");
		 
		 log.info("Register - Step 06: Click Register Button");
		 registerPage.clickToRegisterButton();
		 
		 log.info("Register - Step 07: Verify success message register is displayed");
		 verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
	 }
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }

}