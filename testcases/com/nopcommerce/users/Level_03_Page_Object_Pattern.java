package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_Pattern extends BasePage {
	
	 WebDriver driver;
	 String projectPath = System.getProperty("user.dir");
	 String emailAddress = getEmailAddress();
	 HomePageObject homePage;
	 RegisterPageObject registerPage;
	 LoginPageObject loginPage;
	 CustomerPageObject customerPage;
	 
	 @BeforeClass
	 public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		
		 driver.get("https://demo.nopcommerce.com/");
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }
	  
	 @Test
	 public void Register_01_Empty_Data() {
		 homePage = new HomePageObject(driver);
		 
		 homePage.clickToRegisterLink();
		 
		 registerPage = new RegisterPageObject(driver);
		 registerPage.clickToRegisterButton();
		 
		 Assert.assertEquals(registerPage.getFirtNameErrorMessage(), "First name is required.");
		 Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		 Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		 Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		 Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
		 
	 }
	  
	 @Test
	 public void Register_02_Invalid_Email() {
		 registerPage.clickToHomePageLogo();
		 
		 homePage = new HomePageObject(driver);
		 
		 homePage.clickToRegisterLink();
		 
		 registerPage = new RegisterPageObject(driver);
		 
		 registerPage.enterToFirstNameTextbox("John");
		 registerPage.enterToLastNameTextbox("Wick");
		 registerPage.enterToEmailTextbox("john@wick@gmail.com");
		 registerPage.enterToPasswordTextbox("123456");
		 registerPage.enterToConfirmPasswordTextbox("123456");
		 
		 registerPage.clickToRegisterButton();
		 
		 Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
		 
	 }
	  
	 @Test
	 public void Register_03_Invalid_Password() {
		 registerPage.clickToHomePageLogo();
		 
		 homePage = new HomePageObject(driver);
		 
		 homePage.clickToRegisterLink();
		 
		 registerPage = new RegisterPageObject(driver);
		 
		 registerPage.enterToFirstNameTextbox("John");
		 registerPage.enterToLastNameTextbox("Wick");
		 registerPage.enterToEmailTextbox("johnwick@gmail.com");
		 registerPage.enterToPasswordTextbox("123");
		 registerPage.enterToConfirmPasswordTextbox("123");
		 
		 registerPage.clickToRegisterButton();
		 
		 Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\n"
		 		+ "must have at least 6 characters");
	 }
	  
	 @Test
	 public void Register_04_Incorrect_Confirm_Password() {
		 registerPage.clickToHomePageLogo();
		 
		 homePage = new HomePageObject(driver);
		 
		 homePage.clickToRegisterLink();
		 
		 registerPage = new RegisterPageObject(driver);
		 
		 registerPage.enterToFirstNameTextbox("John");
		 registerPage.enterToLastNameTextbox("Wick");
		 registerPage.enterToEmailTextbox("johnwick@gmail.com");
		 registerPage.enterToPasswordTextbox("123456");
		 registerPage.enterToConfirmPasswordTextbox("1234567");
		 
		 registerPage.clickToRegisterButton();
		 
		 Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	 }
	  
	 @Test
	 public void Register_05_Success() {
		 registerPage.clickToHomePageLogo();
		 
		 homePage = new HomePageObject(driver);
		 
		 homePage.clickToRegisterLink();
		 
		 registerPage = new RegisterPageObject(driver);
		 
		 registerPage.enterToFirstNameTextbox("John");
		 registerPage.enterToLastNameTextbox("Wick");
		 registerPage.enterToEmailTextbox(emailAddress);
		 registerPage.enterToPasswordTextbox("123456");
		 registerPage.enterToConfirmPasswordTextbox("123456");
		 
		 registerPage.clickToRegisterButton();
		 
		 Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		 registerPage.clickToHomePageLogo();
		 homePage = new HomePageObject(driver);
		 
		 homePage.clickToLoginLink();
		 loginPage = new LoginPageObject(driver);
		 
		 loginPage.enterToEmailTextbox(emailAddress);
		 loginPage.enterToPasswordTextbox("123456");
		 loginPage.clickToLoginButton();
		 
		 homePage = new HomePageObject(driver);
		 homePage.clickToMyAccountLink();
		 
		 customerPage = new CustomerPageObject(driver);
		 
		 Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		 Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
		 Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
		 
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }
	 
	 public String getEmailAddress() {
		 String name = "johnwick";
		 Random rad = new Random();
		 return name + rad.nextInt(9999) + "@gmail.com";
	 }
}
