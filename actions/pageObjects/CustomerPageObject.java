package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.AddressesPageUI;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage {
	private WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, CustomerPageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, CustomerPageUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}

	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, CustomerPageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, CustomerPageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}
}
