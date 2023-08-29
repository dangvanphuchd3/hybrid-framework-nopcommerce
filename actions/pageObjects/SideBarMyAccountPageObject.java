package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.SidebarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage{
	WebDriver driver;
	
	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, SidebarMyAccountPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}

	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, SidebarMyAccountPageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}
	
	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, SidebarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}
	
	public CustomerPageObject openCustomerInforPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.CUSTOMER_INFOR_PAGE_LINK);
		clickToElement(driver, SidebarMyAccountPageUI.CUSTOMER_INFOR_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	public SideBarMyAccountPageObject openDynamicSideBarPage(String pageName) {
		waitForElementClickable(driver, SidebarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, SidebarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		
		switch (pageName) {
		case "Customer infor":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Address":
			return PageGeneratorManager.getAddressesPage(driver);
		case "Orders":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointPage(driver);
		default:
			new RuntimeException("Sidebar page name is incorrect.");
			return null;
		}
	}
}
