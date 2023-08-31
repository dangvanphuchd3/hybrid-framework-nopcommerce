package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.AddressesPageObject;
import pageObjects.DownloadableProductPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.RewardPointPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static pageObjects.HomePageObject getHomePage(WebDriver driver) {
		return new pageObjects.HomePageObject(driver);
	}
	
	public static pageObjects.LoginPageObject getLoginPage(WebDriver driver) {
		return new pageObjects.LoginPageObject(driver);
	}
	
	public static pageObjects.RegisterPageObject getRegisterPage(WebDriver driver) {
		return new pageObjects.RegisterPageObject(driver);
	}
	
	public static pageObjects.CustomerPageObject getCustomerPage(WebDriver driver) {
		return new pageObjects.CustomerPageObject(driver);
	}
	
	public static DownloadableProductPageObject getDownloadableProductPage(WebDriver driver) {
		return new DownloadableProductPageObject(driver);
	}
	
	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	
	public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static OrdersPageObject getOrdersPage(WebDriver driver) {
		return new OrdersPageObject(driver);
	}
}
