package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void acceptToAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String valueToSendkey) {
		waitForAlertPresence(driver).sendKeys(valueToSendkey);
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}
	
	public void switchToWindowByID (WebDriver driver, String otherID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			if (!id.equals(otherID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
			}
		}
	}
	
	public void switchToWindowByPageTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}
	
	public void closeAllWindownWithoutExpectedID(WebDriver driver, String expectedID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			if(!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedID);
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public By getByXpath(String xpathExpression) {
		return By.xpath(xpathExpression);
	}
	
	public WebElement getElement(WebDriver driver, String xpathExpression) {
		return driver.findElement(getByXpath(xpathExpression));
	}
	
	public List<WebElement> getListElement(WebDriver driver, String xpathExpression) {
		return driver.findElements(getByXpath(xpathExpression));
	}
	
	public void clickToElement(WebDriver driver, String xpathExpression) {
		getElement(driver, xpathExpression).click();
	}
	
	public void sendKeyToElement(WebDriver driver, String xpathExpression, String value) {
		getElement(driver, xpathExpression).clear();
		getElement(driver, xpathExpression).sendKeys(value);
	}
	
	public String getElementText(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).getText();
	}
	
	public void selectDropdown(WebDriver driver, String xpathExpression, String itemText) {
		new Select(getElement(driver, xpathExpression)).selectByVisibleText(itemText);
	}
	
	public String getFirstSelectedOptionText(WebDriver driver, String xpathExpression) {
		return new Select(getElement(driver, xpathExpression)).getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathExpression) {
		return new Select(getElement(driver, xpathExpression)).isMultiple();
	}
	
	public void selectItemInDropdown(WebDriver driver, String xpathParent, String xpathChild, String expectedText) {
		driver.findElement(By.cssSelector(xpathParent)).click();
		
		List<WebElement> allItems = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathChild)));
		
		for (WebElement tempElement : allItems) {	
			if (tempElement.getText().equals(expectedText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
				sleepInSecond(1);
				
				tempElement.click();
				sleepInSecond(1);
				
				break;
			}
		}
	}
	
	public String getElementAttribute(WebDriver driver, String xpathExpression, String attributeName) {
		return getElement(driver, xpathExpression).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String xpathExpression, String propertyName) {
		return getElement(driver, xpathExpression).getCssValue(propertyName);
	}
	
	public String getHexaColorByGRBA(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex().toUpperCase();
	}
	
	public int getListElementSize(WebDriver driver, String xpathExpression) {
		return getListElement(driver, xpathExpression).size();
	}
	
	public void checkToCheckboxRadio(WebDriver driver, String xpathExpression) {
		if(!isElementSelected(driver, xpathExpression)) {
			clickToElement(driver, xpathExpression);
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String xpathExpression) {
		if(isElementSelected(driver, xpathExpression)) {
			clickToElement(driver, xpathExpression);
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isEnabled();
	}
}
