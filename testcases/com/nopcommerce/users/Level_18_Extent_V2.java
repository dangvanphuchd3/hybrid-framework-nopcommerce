//package com.nopcommerce.users;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.HomePageObject;
//import pageObjects.LoginPageObject;
//import pageObjects.RegisterPageObject;
//import reportConfig.ExtentManager;
//
//public class Level_18_Extent_V2 extends BaseTest {
//	 private WebDriver driver;
//	 private HomePageObject homePage;
//	 private RegisterPageObject registerPage;
//	 private LoginPageObject loginPage;
//	 private String emailAddress = getEmailAddress();
//	 String firstName, lastName;
//	 
//	 @Parameters({"browser"})
//	 @BeforeClass
//	 public void beforeClass(String browserName) {
//		 driver = getBrowserDriver(browserName);
//		 homePage = PageGeneratorManager.getHomePage(driver);
//		 registerPage = PageGeneratorManager.getRegisterPage(driver);
//		 
//		 firstName = "John";
//		 lastName = "Wick";
//	 }
//
//	 @Test
//	 public void User_01_Register_Validate(Method method) {
//		 ExtentManager.startTest(method.getName(),"User_01_Register_Validate");
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Verify Register link is displayed");
//		 Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Click To Register Link");
//		 registerPage = homePage.clickToRegisterLink();
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Click Register Button");
//		 registerPage.clickToRegisterButton();
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Verify error message at 'FirtName' Textbox is 'First name is required.'");
//		 Assert.assertEquals(registerPage.getFirtNameErrorMessage(), "First name is required");
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Verify error message at 'Email' Textbox is 'Email is required.'");
//		 Assert.assertEquals(registerPage.getEmailErrorMessage(),"Email is required.");
//	 }
//	 
//	 @Test
//	 public void User_02_Register_Success(Method method) {
//		 ExtentManager.startTest(method.getName(),"User_02_Register_Success");
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Enter to 'FirstName' Textbox is " + firstName);
//		 registerPage.refreshCurrentPage(driver);
//		 registerPage.enterToFirstNameTextbox(firstName);
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to 'LastName' Textbox is " + lastName);
//		 registerPage.enterToLastNameTextbox(lastName);
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to 'Email' Textbox is " + emailAddress);
//		 registerPage.enterToEmailTextbox(emailAddress);
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to 'Password' Textbox");
//		 registerPage.enterToPasswordTextbox("123456");
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to 'ConfirmPassword' Textbox");
//		 registerPage.enterToConfirmPasswordTextbox("123456");
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Click Register Button");
//		 registerPage.clickToRegisterButton();
//		 
//		 ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Verify success message register is displayed");
//		 Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//	 }
//	 @AfterClass
//	 public void afterClass() {
//		 driver.quit();
//	 }
//
//}