package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerPageObject;
import pageObjects.DownloadableProductPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Level_07_Switch_Multiple_Page extends BaseTest {
	 private WebDriver driver;
	 private String emailAddress = getEmailAddress();
	 
	 // Không thuộc SideBar sẽ không được gọi
	 private HomePageObject homePage;
	 private RegisterPageObject registerPage;
	 private LoginPageObject loginPage;
	 
	 // Thuộc SideBar sẽ gọi các hàm trong SideBar dùng được
	 private CustomerPageObject customerPage;
	 private DownloadableProductPageObject downloadableProductPage;
	 private RewardPointPageObject rewardPointPage;
	 private AddressesPageObject addressesPage;
	 @Parameters("browser")
	 @BeforeClass
	 public void beforeClass(String browserName) {
		 driver = getBrowserDriver(browserName);
		 
		 homePage = PageGeneratorManager.getHomePage(driver);
	 }
	  
	 @Test
	 public void User_01_Register() {
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
		 
		 homePage = loginPage.loginAsUser(emailAddress, "123456");
		 
		 customerPage = homePage.clickToMyAccountLink();
		 
		 Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		 Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
		 Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	 }
	 
	 @Test
	 public void User_02_Switch_Multiple_Page() {
		 // Customer Infor => Downloadable products
		 downloadableProductPage = customerPage.openDownloadableProductPage();
		 // ...
		 
		 // Downloadable products => Addresses
		 addressesPage = downloadableProductPage.openAddressesPage();
		 // ...
		 
		 // Addresses => Reward points
		 rewardPointPage = addressesPage.openRewardPointPage();
		 // ...
		 
		 // Reward points => Customer Infor
		 customerPage = rewardPointPage.openCustomerInforPage();
		 
		 // Customer Infor => Addresses
		 addressesPage = customerPage.openAddressesPage();
		 
		 // Addresses => Downloadable products
		 downloadableProductPage = addressesPage.openDownloadableProductPage();
		 
		 
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }
	 
}
