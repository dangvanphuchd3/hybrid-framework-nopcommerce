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
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class Level_11_Dynamic_Locator_Rest_Param extends BaseTest {
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
	 
	 private AdminLoginPageObject adminLoginPage;
	 private AdminDashboardPageObject adminDashboardPage;
	 
	 private String userUrl, adminUrl;
	 
	 @Parameters({"browser", "userUrl", "adminUrl"})
	 @BeforeClass
	 public void beforeClass(String browserName, String userUrl, String adminUrl) {
		 driver = getBrowserDriver(browserName, userUrl);
		 homePage = PageGeneratorManager.getHomePage(driver);
		 
		 this.userUrl = userUrl;
		 this.adminUrl = adminUrl;
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
	 public void User_02_Page_Navigation() {
		 // Đều nằm trong SideBar
		 
		 // Customer Page -> Address Page
		 addressesPage = (AddressesPageObject) customerPage.openDynamicSideBarPage("Addresses");
		 
		 // Address Page -> Order Page
		 orderPage = addressesPage.openOrderPage();
		 
		 // Order Page -> Customer Page
		 customerPage = orderPage.openDynamicSideBarPage("Orders");
		 
		 // Customer Page -> Order Page
		 orderPage = 
		 
		 // Order Page -> Address Page
		 
		 // Address Page -> Reward Point Page
				 
				 
		 // Reward Point Page -> Customer Page
		 customerPage = (CustomerPageObject) rewardPointPage.openDynamicSideBarPage("Customer infor");
		 
		 // Customer Page -> Reward Point Page
		 rewardPointPage = (RewardPointPageObject) customerPage.openDynamicSideBarPage("Reward points");
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }
	 
}