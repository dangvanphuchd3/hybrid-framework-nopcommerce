package com.jquery.upload;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;

public class Level_14_Upload_File extends BaseTest {
	 WebDriver driver;
	 UploadPageObject uploadPage;
	 String beach = "beach.jpg";
	 String computer = "computer.jpg";
	 String mountain = "mountain.jpg";

	 @Parameters({"browser", "url"})
	 @BeforeClass
	 public void beforeClass(String browserName, String url) {
		 driver = getBrowserDriver(browserName, url);
		 uploadPage = PageGeneratorManager.getUploadPage(driver);

	 }

	 @Test
	 public void TC_01_Upload_Single_File() {
		 uploadPage.uploadMultipleFiles(driver, beach);
		 uploadPage.sleepInSecond(2);

		 uploadPage.uploadMultipleFiles(driver, computer);
		 uploadPage.sleepInSecond(2);

		 uploadPage.uploadMultipleFiles(driver, mountain);
		 uploadPage.sleepInSecond(2);

		 Assert.assertTrue(uploadPage.isFileLoadedSuccess(beach));
		 Assert.assertTrue(uploadPage.isFileLoadedSuccess(computer));
		 Assert.assertTrue(uploadPage.isFileLoadedSuccess(mountain));

		 uploadPage.clickStartButtonEachFile();

		 Assert.assertTrue(uploadPage.isFileUploadedSuccess(beach));
		 Assert.assertTrue(uploadPage.isFileUploadedSuccess(computer));
		 Assert.assertTrue(uploadPage.isFileUploadedSuccess(mountain));
	 }

	 @Test
	 public void TC_02_Upload_Multiple_File() {

	 }

	 @AfterClass
	 public void afterClass() {
		 closeBrowser();
	 }

}