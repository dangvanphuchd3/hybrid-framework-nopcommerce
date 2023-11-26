package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import pageUIs.SidebarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BaseElement {
	WebDriver driver;

	public SideBarMyAccountPageObject(WebDriver driver) {
		super(driver);
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

	public OrdersPageObject openOrdersPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.ORDER_LINK_TEXT);
		clickToElement(driver, SidebarMyAccountPageUI.ORDER_LINK_TEXT);
		return PageGeneratorManager.getOrdersPage(driver);
	}

	public SideBarMyAccountPageObject openDynamicSideBarPage(String pageName) {
		waitForElementClickable(driver, SidebarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, SidebarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);

		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressesPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrdersPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointPage(driver);
		default:
			new RuntimeException("Sidebar page name is incorrect.");
			return null;
		}
	}

	public void openDynamicSideBarPageByName (String pageName) {
		waitForElementClickable(driver, SidebarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, SidebarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
	}
}
