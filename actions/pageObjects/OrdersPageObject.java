package pageObjects;

import org.openqa.selenium.WebDriver;

public class OrdersPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
