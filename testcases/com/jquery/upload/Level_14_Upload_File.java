package com.jquery.upload;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_14_Upload_File extends BaseTest {
	 WebDriver driver;

	 @Parameters({"browser", "url"})
	 @BeforeClass
	 public void beforeClass(String browserName, String url) {
		 driver = getBrowserDriver(browserName, url);
		 
	 }
	 
	 @Test
	 public void TC_01_Upload_Single_File() {

	 }
	 
	 @Test
	 public void TC_02_Upload_Multiple_File() {
		
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 closeBrowser();
	 }
	 
}