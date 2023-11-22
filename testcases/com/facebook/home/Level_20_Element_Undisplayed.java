package com.facebook.home;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_20_Element_Undisplayed extends BaseTest {
	 WebDriver driver;
	 private String emailAddress = getEmailAddress();
	 
	 @Parameters({"browser","url"})
	 @BeforeClass
	 public void beforeClass(String browserName, String urlValue) {
		 driver = getBrowserDriver(browserName, urlValue);
		 
	 }

	 @Test
	 public void Home_01_Element_Displayed() {
		 
	 }
	 
	 @Test
	 public void Home_02_Element_UnDisplayed_In_HTML() {
		 
	 }
	 
	 @Test
	 public void Home_03_Element_UnDisplayed_Not_In_HTML() {
		 
	 }
	 
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }

}