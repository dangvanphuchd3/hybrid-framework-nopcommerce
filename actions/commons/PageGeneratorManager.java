package commons;

import org.openqa.selenium.WebDriver;

import pageFactory.HomePageObject;

public class PageGeneratorManager {
	
	public static pageObjects.HomePageObject getHomePage(WebDriver driver) {
		return new pageObjects.HomePageObject(driver);
	}
}
