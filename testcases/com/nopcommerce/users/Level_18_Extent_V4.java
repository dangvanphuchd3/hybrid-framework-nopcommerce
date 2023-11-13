package com.nopcommerce.users;

import java.lang.reflect.Method;

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

public class Level_18_Extent_V4 extends BaseTest {
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
		 registerPage = PageGeneratorManager.getRegisterPage(driver);
		 
		 firstName = "John";
		 lastName = "Wick";
	 }

	 @Test
	 public void User_01_Register_Validate(Method method) {
		 Assert.assertFalse(homePage.isRegisterLinkDisplayed());
		 
		 registerPage = homePage.clickToRegisterLink();
		 
		 registerPage.clickToRegisterButton();
		 
		 Assert.assertEquals(registerPage.getFirtNameErrorMessage(), "First name is required");
		 
		 Assert.assertEquals(registerPage.getEmailErrorMessage(),"Email is required.");
	 }
	 
	 @Test
	 public void User_02_Register_Success(Method method) {
		 registerPage = homePage.clickToRegisterLink();
		 
		 registerPage.enterToFirstNameTextbox(firstName);
		 
		 registerPage.enterToLastNameTextbox(lastName);
		 
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