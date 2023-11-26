package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObject;
import pageUIs.BaseElementUI;

public class BaseElement extends BasePage {
	WebDriver driver;
	
	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}
	
	// Hàm này theo business bất kỳ hàm nào cũng nhìn thấy nó và click vào được
	public HomePageObject clickToHomePageLogo() {
		waitForElementClickable(driver, BaseElementUI.HOME_PAGE_LOGO_IMAGE);
		clickToElement(driver, BaseElementUI.HOME_PAGE_LOGO_IMAGE);
		return new HomePageObject(driver);
	}
	
	// Theo business bất kỳ page nào cũng gọi được
	public void clickToHeaderLinkByName(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
	}
	
	public void clickToButtonByText(String buttonText) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}
	
	public String getTextboxErrorMessageByID(String errorMessageID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID, errorMessageID);
		return getElementText(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID, errorMessageID);
	}
	
	public void enterToTextboxByID(String textboxID, String valueToSendkey) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendKeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSendkey, textboxID);
	}
	
	public String getTextboxAttributeByID(String textboxID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
}
