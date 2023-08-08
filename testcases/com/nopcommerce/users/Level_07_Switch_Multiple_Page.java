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

public class Level_07_Switch_Multiple_Page extends BaseTest {
	 WebDriver driver;
	 String emailAddress = getEmailAddress();
	 HomePageObject homePage;
	 RegisterPageObject registerPage;
	 LoginPageObject loginPage;
	 CustomerPageObject customerPage;
	 
	 @Parameters("browser")
	 @BeforeClass
	 public void beforeClass(String browserName) {
		 driver = getBrowserDriver(browserName);
		 
		 homePage = PageGeneratorManager.getHomePage(driver);
	 }
	  
	 @Test
	 public void Register_05_Success() {
		 homePage = registerPage.clickToHomePageLogo();
		 
		 registerPage = homePage.clickToRegisterLink();
		 
		 registerPage.enterToFirstNameTextbox("John");
		 registerPage.enterToLastNameTextbox("Wick");
		 registerPage.enterToEmailTextbox(emailAddress);
		 registerPage.enterToPasswordTextbox("123456");
		 registerPage.enterToConfirmPasswordTextbox("123456");
		 
		 registerPage.clickToRegisterButton();
		 
		 Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		 homePage = registerPage.clickToHomePageLogo();
		 
		 loginPage = homePage.clickToLoginLink();
		 
		 loginPage.enterToEmailTextbox(emailAddress);
		 loginPage.enterToPasswordTextbox("123456");
		 homePage = loginPage.clickToLoginButton();
		
		 customerPage = homePage.clickToMyAccountLink();
		 
		 Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		 Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
		 Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
		 
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }
	 
}
