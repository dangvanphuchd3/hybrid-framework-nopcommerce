package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.BasePageUI;

public class SideBarMyAccountPageObject extends BasePage{
	WebDriver driver;
	
	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DownloadableProductPageObject openDownloadableProductPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}

	public AddressesPageObject openAddressesPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, BasePageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}
	
	public RewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}
	
	public CustomerPageObject openCustomerInforPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_PAGE_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFOR_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
}
