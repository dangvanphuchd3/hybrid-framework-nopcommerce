package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.DownloadableProductPageUI;

public class DownloadableProductPageObject extends BasePage {
	WebDriver driver;
	
	public DownloadableProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddressesPageObject openAddressPage() {
		waitForElementClickable(driver, DownloadableProductPageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, DownloadableProductPageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}
}
