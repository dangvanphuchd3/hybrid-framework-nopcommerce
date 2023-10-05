package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_15_Assert_Verify extends BaseTest {
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
		 // Verify register link displayed -> FAILED
		 verifyFalse(homePage.isRegisterLinkDisplayed());
		 
		 registerPage = homePage.clickToRegisterLink();
		 
		 registerPage.clickToRegisterButton();

		 registerPage.enterToFirstNameTextbox("John");
		 registerPage.enterToLastNameTextbox("Wick");
		 registerPage.enterToEmailTextbox(emailAddress);
		 registerPage.enterToPasswordTextbox("123456");
		 registerPage.enterToConfirmPasswordTextbox("123456");

		 registerPage.clickToRegisterButton();

		 Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	 }

	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }

}