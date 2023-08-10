package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.AddressesPageUI;
import pageUIs.CustomerPageUI;

public class AddressesPageObject extends BasePage {
	WebDriver driver;
	
	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, AddressesPageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, AddressesPageUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}

	public DownloadableProductPageObject openDownloadableProduct() {
		waitForElementClickable(driver, AddressesPageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, AddressesPageUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
}
