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

public class Level_16_Log extends BaseTest {
	 private WebDriver driver;
	 private HomePageObject homePage;
	 private RegisterPageObject registerPage;
	 private LoginPageObject loginPage;
	 private String emailAddress = getEmailAddress();

	 @Parameters({"browser"})
	 @BeforeClass
	 public void beforeClass(String browserName) {
		 driver = getBrowserDriver(browserName);
		 homePage = PageGeneratorManager.getHomePage(driver);
	 }

	 @Test
	 public void User_01_Register() {
		 log.info("User_01 - Step 01: Verify Register link is displayed");
		 verifyFalse(homePage.isRegisterLinkDisplayed());
		 
		 log.info("User_01 - Step 02: Click To Register Link");
		 registerPage = homePage.clickToRegisterLink();
		 
		 log.info("User_01 - Step 03: Click Register Button");
		 registerPage.clickToRegisterButton();
		 
		 log.info("User_01 - Step 04: Verify error message at FirtName Textbox");
		 verifyEquals(registerPage.getFirtNameErrorMessage(), "First name is required");
		 
		 log.info("User_01 - Step 05: Verify error message at Email Textbox");
		 verifyEquals(registerPage.getEmailErrorMessage(),"Email is required.");
		 
		 log.info("User_01 - Step 06: Enter to FirstName Textbox");
		 registerPage.enterToFirstNameTextbox("John");
		 
		 log.info("User_01 - Step 07: Enter to LastName Textbox");
		 registerPage.enterToLastNameTextbox("Wick");
		 
		 log.info("User_01 - Step 08: Enter to Email Textbox");
		 registerPage.enterToEmailTextbox(emailAddress);
		 
		 log.info("User_01 - Step 09: Enter to Password Textbox");
		 registerPage.enterToPasswordTextbox("123456");
		 
		 log.info("User_01 - Step 10: Enter to ConfirmPassword Textbox");
		 registerPage.enterToConfirmPasswordTextbox("123456");
		 
		 log.info("User_01 - Step 11: Click Register Button");
		 registerPage.clickToRegisterButton();
		 
		 log.info("User_01 - Step 12: Verify success message register is displayed");
		 verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

	 }

	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }

}