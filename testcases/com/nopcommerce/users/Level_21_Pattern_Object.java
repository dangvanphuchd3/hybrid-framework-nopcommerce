package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_21_Pattern_Object extends BaseTest {
	 WebDriver driver;
	 String emailAddress = getEmailAddress();
	 HomePageObject homePage;
	 RegisterPageObject registerPage;
	 LoginPageObject loginPage;
	 CustomerPageObject customerPage;

	 private String userUrl, adminUrl;

	 @Parameters({"browser", "userUrl", "adminUrl"})
	 @BeforeClass
	 public void beforeClass(String browserName, String userUrl, String adminUrl) {
		 driver = getBrowserDriver(browserName, userUrl);

		 homePage = PageGeneratorManager.getHomePage(driver);

		 this.userUrl = userUrl;
		 this.adminUrl = adminUrl;
	 }

	 @Test
	 public void Register_01_Empty_Data() { 
		 homePage.clickToHeaderLinkByName("Register");
		 registerPage = PageGeneratorManager.getRegisterPage(driver);

		 registerPage.clickToButtonByText("Register");
		 
		 Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"), "First name is required.");
		 Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"), "Last name is required.");
		 Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Email is required.");
		 Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"), "Password is required.");
		 Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "Password is required.");

	 }

	 @Test
	 public void Register_02_Invalid_Email() {
		 homePage = registerPage.clickToHomePageLogo();

		 homePage.clickToHeaderLinkByName("Register");
		 registerPage = PageGeneratorManager.getRegisterPage(driver);
		 
		 registerPage.enterToTextboxByID("FirstName", "John");
		 registerPage.enterToTextboxByID("LastName", "Wick");
		 registerPage.enterToTextboxByID("Email", emailAddress + "@");
		 registerPage.enterToTextboxByID("Password", "123456");
		 registerPage.enterToTextboxByID("ConfirmPassword", "123456");

		 registerPage.clickToButtonByText("Register");

		 Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Wrong email");

	 }

	 @Test
	 public void Register_03_Invalid_Password() {
		 homePage = registerPage.clickToHomePageLogo();

		 homePage.clickToHeaderLinkByName("Register");
		 registerPage = PageGeneratorManager.getRegisterPage(driver);
		 
		 registerPage.enterToTextboxByID("FirstName", "John");
		 registerPage.enterToTextboxByID("LastName", "Wick");
		 registerPage.enterToTextboxByID("Email", emailAddress);
		 registerPage.enterToTextboxByID("Password", "123");
		 registerPage.enterToTextboxByID("ConfirmPassword", "123");

		 registerPage.clickToButtonByText("Register");

		 Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"), "Password must meet the following rules:\n"
		 		+ "must have at least 6 characters");
	 }

	 @Test
	 public void Register_04_Incorrect_Confirm_Password() {
		 homePage = registerPage.clickToHomePageLogo();

		 homePage.clickToHeaderLinkByName("Register");
		 registerPage = PageGeneratorManager.getRegisterPage(driver);
		 
		 registerPage.enterToTextboxByID("FirstName", "John");
		 registerPage.enterToTextboxByID("LastName", "Wick");
		 registerPage.enterToTextboxByID("Email", emailAddress);
		 registerPage.enterToTextboxByID("Password", "123456");
		 registerPage.enterToTextboxByID("ConfirmPassword", "1234567");

		 registerPage.clickToButtonByText("Register");

		 Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "The password and confirmation password do not match.");
	 }

	 @Test
	 public void Register_05_Success() {
		 homePage = registerPage.clickToHomePageLogo();

		 homePage.clickToHeaderLinkByName("Register");
		 registerPage = PageGeneratorManager.getRegisterPage(driver);

		 registerPage.enterToTextboxByID("FirstName", "John");
		 registerPage.enterToTextboxByID("LastName", "Wick");
		 registerPage.enterToTextboxByID("Email", emailAddress);
		 registerPage.enterToTextboxByID("Password", "123456");
		 registerPage.enterToTextboxByID("ConfirmPassword", "123456");

		 registerPage.clickToButtonByText("Register");

		 Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		 homePage = registerPage.clickToHomePageLogo();

		 homePage.clickToHeaderLinkByName("Log in");
		 loginPage = PageGeneratorManager.getLoginPage(driver);

		 loginPage.enterToTextboxByID("Email", emailAddress);
		 loginPage.enterToTextboxByID("Password", "123456");
		 
		 loginPage.clickToButtonByText("Log in");
		 homePage = PageGeneratorManager.getHomePage(driver);

		 homePage.clickToHeaderLinkByName("My account");
		 customerPage = PageGeneratorManager.getCustomerPage(driver);

		 Assert.assertEquals(customerPage.getTextboxAttributeByID("FirstName"), "John");
		 Assert.assertEquals(customerPage.getTextboxAttributeByID("LastName"), "Wick");
		 Assert.assertEquals(customerPage.getTextboxAttributeByID("Email"), emailAddress);

	 }

	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }

}
