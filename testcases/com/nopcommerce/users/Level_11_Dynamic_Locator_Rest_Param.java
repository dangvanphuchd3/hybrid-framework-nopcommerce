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
	 public void User_02_Switch_Multiple_Page() {
		 // Customer Page
		 
		 // ...
		 
		 // Logout ra (từ trang User)
		 homePage = customerPage.userAbleToLogout(driver);
		 
		 // Qua trang Admin
		 homePage.openUrl(driver, adminUrl);
		 adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		 
		 // Login vào thành công
		 adminDashboardPage = adminLoginPage.loginAsAdmin("admin@yourstore.com", "admin");
		 Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
		 
		 // ...
		 
		 // Logout ra (từ trang Admin)
		 adminLoginPage = adminDashboardPage.adminAbleToLogout(driver);
		 
		 // Qua trang User
		 adminLoginPage.openUrl(driver, userUrl);
		 homePage = PageGeneratorManager.getHomePage(driver);
		 
		 // Login vào
		 loginPage = homePage.clickToLoginLink();
		 
		 homePage = loginPage.loginAsUser(emailAddress, "123456");
		 // ...
		 
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }
	 
}