package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.print.PageMargin;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.RewardPointPageUI;

public class RewardPointPageObject extends BasePage {
	WebDriver driver;
	
	public RewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public CustomerPageObject openCustomerInforPage() {
		waitForElementClickable(driver, RewardPointPageUI.CUSTOMER_INFOR_PAGE_LINK);
		clickToElement(driver, RewardPointPageUI.CUSTOMER_INFOR_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
}
