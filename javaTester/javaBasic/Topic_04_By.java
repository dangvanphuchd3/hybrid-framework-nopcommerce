package javaBasic;

import org.openqa.selenium.By;

public class Topic_04_By {
	public static void main(String[] args) {
		// Đầu vào là xpath/ css/ id/ name/ class/ tagname/ linkText/ partialLinkText
		// Đầu ra là nó sẽ lấy đúng loại By tương ứng
		
		// xpath=//input[@id='name'] -> By.xpath
		// id=name -> By.id
		// css=input[id='name'] -> By.cssSelector
		// name=email -> By.name
		
		String locatorValue = "xpath=//input[@id='name']";
		
		System.out.println(locatorValue.substring(6));
	}
	
	public static By getByLocator(String locatorValue) {
		By by = null;
		
		if (condition) {
			
		} else {

		}
		return null;
	}
}
