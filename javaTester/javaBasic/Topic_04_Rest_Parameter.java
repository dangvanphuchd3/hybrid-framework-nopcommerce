package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Rest_Parameter {
	String addressLink = "//div[@class='listbox']//a[text()='Addresses']";
	String orderLink = "//div[@class=side-2']//a[text()='Orders']";
	
	String sidebarLink = "//div[@class=side-2']//a[text()='%s']";
	
	String dynamicLink = "//div[@class='%s']//a[text()='%s']";
	
	String dynamicMenuLink = "//div[@class='%s']//div[@class='%s']//a[text()='%s']";
	
	String afghanistan = "//td[@data-key='females' and text()='384187']/following-sibling::td[@data-key='country' and text()='Afghanistan']"
			+ "/following-sibling::td[@data-key='males' and text()='407124']/following-sibling::td[@data-key='total' and text()='791312']";
	String dynamicCountry = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']"
			+ "/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	@Test
	public void TC_01_Rest_Param() {
		// Cố định
		clickToElement(addressLink);
		clickToElement(orderLink);
		
		// 1 param
		clickToElement(sidebarLink, "Orders");
		
		// 2 param
		clickToElement(dynamicLink, "footer", "Orders");
		
		// 3 param
		clickToElement(dynamicMenuLink, "footer", "Computer", "Orders");
		
		// 4 param
		clickToElement(dynamicCountry, "750", "Aruba", "756", "1504");
	}
	
	// Hàm click vào 1 element cố định
	public void clickToElement (String locatorValue) {
		System.out.println("Click to: " + locatorValue);
	}
	
	// Hàm click vào 1 element không cố định (dynamic) vs 1 tham số
	public void clickToElement (String locatorValue, String pageName) {
		locatorValue = String.format(locatorValue, pageName);
		System.out.println("Click to: " + locatorValue);
	}
	
	// Hàm click vào 1 element không cố định (dynamic) vs 2 tham số
	public void clickToElement (String locatorValue, String pageType, String pageName) {
		locatorValue = String.format(locatorValue, pageType, pageName);
		System.out.println("Click to: " + locatorValue);
	}
	
	// Hàm click vào 1 element không cố định (dynamic) vs 3 tham số
	public void clickToElement (String locatorValue, String pageType, String category, String pageName) {
		locatorValue = String.format(locatorValue, pageType, category, pageName);
		System.out.println("Click to: " + locatorValue);
	}
	
	// Hàm click vào 1 element không cố định (dynamic) vs 4 tham số
	public void clickToElement (String locatorValue, String femals, String country, String males, String total) {
		locatorValue = String.format(locatorValue, femals, country, males, total);
		System.out.println("Click to: " + locatorValue);
	}
}
