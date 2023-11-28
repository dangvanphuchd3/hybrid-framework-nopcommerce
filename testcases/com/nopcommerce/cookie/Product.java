package com.nopcommerce.cookie;

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

public class Product extends BaseTest {
	 WebDriver driver;
	 HomePageObject homePage;
	 RegisterPageObject registerPage;
	 LoginPageObject loginPage;
	 CustomerPageObject customerPage;

	 @Parameters("browser")
	 @BeforeClass
	 public void beforeClass(String browserName) {
		 driver = getBrowserDriver(browserName);
		 homePage = PageGeneratorManager.getHomePage(driver);
		 
		 loginPage = homePage.clickToLoginLink();
		 
		 loginPage.setCookies(driver, Common_Register.cookies);
		 loginPage.sleepInSecond(5);
		 loginPage.refreshCurrentPage(driver);

		 customerPage = homePage.openMyAccountLink();

		 Assert.assertEquals(customerPage.getFirstNameAttributeValue(), Common_Register.firstName);
		 Assert.assertEquals(customerPage.getLastNameAttributeValue(), Common_Register.lastName);
		 Assert.assertEquals(customerPage.getEmailAttributeValue(), Common_Register.emailAddress);
	 }

	 @Test
	 public void Product_01_New_Product() {
		
	 }
	 
	 @Test
	 public void Product_02_View_Product() {
		
	 }
	 
	 @Test
	 public void Product_03_Edit_Product() {
		
	 }

	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }

}
