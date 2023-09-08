package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_13_Handle_DataTable extends BaseTest {
	 private WebDriver driver;
	 
	 @Parameters({"browser", "url"})
	 @BeforeClass
	 public void beforeClass(String browserName, String url) {
		 driver = getBrowserDriver(browserName, url);
	 }
	  
	 @Test
	 public void User_01_Register() {

	 }
	 
	 @Test
	 public void User_02_Page_Navigation() {

	 }
	 
	 @Test
	 public void User_03_Page_Navigation() {
		 
		 
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 closeBrowser();
	 }
	 
}