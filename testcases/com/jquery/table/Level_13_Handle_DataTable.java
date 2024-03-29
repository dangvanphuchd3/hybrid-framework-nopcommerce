package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_13_Handle_DataTable extends BaseTest {
	 private WebDriver driver;
	 HomePageObject homePage;


	 @Parameters({"browser", "url"})
	 @BeforeClass
	 public void beforeClass(String browserName, String url) {
		 driver = getBrowserDriver(browserName, url);

		 homePage = PageGeneratorManager.getHomePage(driver);
	 }

	 // @Test
	 public void TC_01_Search() {
		 // Search dữ liệu trong 1 Table (trên Header)
		 homePage.inputToColumnTextboxByName("Females","750");
		 homePage.sleepInSecond(2);

		 homePage.inputToColumnTextboxByName("Males","651");
		 homePage.sleepInSecond(2);

		 homePage.inputToColumnTextboxByName("Country","Algeria");
		 homePage.sleepInSecond(2);

		 homePage.inputToColumnTextboxByName("Total","1900");
		 homePage.sleepInSecond(2);
	 }

	 // @Test
	 public void TC_02_Paging() {
		 // Click to any page
		 homePage.clickToPageByNumber("10");
		 homePage.sleepInSecond(2);
		 homePage.isPageActiveByNumber("10");

		 homePage.clickToPageByNumber("12");
		 homePage.sleepInSecond(2);
		 homePage.isPageActiveByNumber("12");

		 homePage.clickToPageByNumber("21");
		 homePage.sleepInSecond(2);
		 homePage.isPageActiveByNumber("21");

		 homePage.clickToPageByNumber("20");
		 homePage.sleepInSecond(2);
		 homePage.isPageActiveByNumber("20");
	 }

	 // @Test
	 public void TC_03_Displayed() {
		 // Verify any row
		 Assert.assertTrue(homePage.isRowValuesDisplayed("384187","Afghanistan","407124","791312"));

		 Assert.assertTrue(homePage.isRowValuesDisplayed("750","Aruba","756","1504"));

		 Assert.assertTrue(homePage.isRowValuesDisplayed("276880","Angola","276472","553353"));

	 }

	 // @Test
	 public void TC_04_Icon_Button_Checkbox() {
		 // Click vào bất kì 1 cái icon/ button/ checkbox/... của 1 row nào đó
		 homePage.clickToRowActionByCountryName("Afghanistan", "remove");
		 homePage.clickToRowActionByCountryName("AFRICA", "remove");
		 homePage.clickToRowActionByCountryName("Albania", "remove");
		 homePage.clickToRowActionByCountryName("Arab Rep of Egypt", "remove");
		 homePage.clickToRowActionByCountryName("Aruba", "remove");
		 homePage.refreshCurrentPage(driver);

		 homePage.clickToRowActionByCountryName("Afghanistan", "edit");
		 homePage.refreshCurrentPage(driver);

		 homePage.clickToRowActionByCountryName("Arab Rep of Egypt", "edit");
		 homePage.refreshCurrentPage(driver);
	 }

	 // @Test
	 public void TC_05_Get_All_Column_Values() {
		 homePage.getAllPageValuesByColumnName("Country");

		 homePage.getAllPageValuesByColumnName("Total");
	 }

	 @Test
	 public void TC_06_Action_By_Index() {
		 homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

		 // Nhập vào textbox tại cột Contact Person dòng thứ 2
		 homePage.enterToTextBoxByColumnNameAndRowIndex("Contact Person", "2", "Oliver Kahl");
		 homePage.enterToTextBoxByColumnNameAndRowIndex("Company", "1", "Luvina Software");

		 // Select dữ liệu tại cột Country dòng thứ 3
		 homePage.selectDropdownByColunmNameAndRowIndex("Country", "3", "United Kingdom");
		 homePage.selectDropdownByColunmNameAndRowIndex("Country", "1", "Japan");

		 // Click vào checkbox tại cột NPO dòng thứ 1
		 homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
		 homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "1");
		 homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "3");
	 }

	 @AfterClass
	 public void afterClass() {
		 closeBrowser();
	 }

}