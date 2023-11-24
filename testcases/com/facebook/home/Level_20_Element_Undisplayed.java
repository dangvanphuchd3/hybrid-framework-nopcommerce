package com.facebook.home;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_20_Element_Undisplayed extends BaseTest {
	 WebDriver driver;
	 HomePageObject homePage;
	 private String emailAddress = getEmailAddress();
	 
	 @Parameters({"browser","url"})
	 @BeforeClass
	 public void beforeClass(String browserName, String urlValue) {
		 driver = getBrowserDriver(browserName, urlValue);
		 
		 homePage = PageGeneratorManager.getHomePage(driver);
		 
	 }

	 @Test
	 public void Home_01_Element_Displayed() {
		 homePage.clickToCreateNewAccountButton();
		 
		 verifyTrue(homePage.isFirstNameTextboxDisplayed());
		 verifyTrue(homePage.isSurNameTextboxDisplayed());
		 verifyTrue(homePage.isEmailTextboxDisplayed());
		 verifyTrue(homePage.isPasswordTextboxDisplayed());
		 
		 homePage.enterToEmailTextbox(emailAddress);
		 verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
	 }
	 
	 @Test
	 public void Home_02_Element_UnDisplayed_In_HTML() {
		 homePage.enterToEmailTextbox("");
		 homePage.sleepInSecond(2);
		 
		 // Sau khi xóa dữ liệu của Email textbox đi - thì Confirm Email textbox không hiển thị trên UI
		 // Nhưng vẫn có trong HTML
		 log.info("Verify Confirm Email textbox is not displayed");
		 verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
	 }
	 
	 @Test
	 public void Home_03_Element_UnDisplayed_Not_In_HTML() {
		 homePage.clickToCloseSignUpPopup();
		 
		 log.info("Verify FirstName textbox is not displayed");
		 verifyFalse(homePage.isFirstNameTextboxDisplayed());
		 
		 log.info("Verify SurName textbox is not displayed");
		 verifyFalse(homePage.isSurNameTextboxDisplayed());
		 
		 log.info("Verify Email textbox is not displayed");
		 verifyFalse(homePage.isEmailTextboxDisplayed());
		 
		 log.info("Verify Password textbox is not displayed");
		 verifyFalse(homePage.isPasswordTextboxDisplayed());
	 }
	 
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }

}