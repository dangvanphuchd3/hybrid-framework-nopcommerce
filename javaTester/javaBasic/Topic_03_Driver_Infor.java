package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class Topic_03_Driver_Infor {

	public static void main(String[] args) {
		// GUID

		// Chrome
		WebDriver driver = new ChromeDriver();
		SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session ID = " + sessionId);
		System.out.println("Driver ID = " + driver.toString());
		driver.quit();
		// Session ID = 1aadf17ca804c7341f88178016da3b24
		// Driver ID = ChromeDriver: chrome on windows (1aadf17ca804c7341f88178016da3b24)

		// Firefox
		driver = new FirefoxDriver();
		sessionId = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session ID = " + sessionId);
		System.out.println("Driver ID = " + driver.toString());
		driver.quit();
		// Session ID = c10bd7b1-e168-474e-923d-32699fb58498
		// Driver ID = FirefoxDriver: firefox on windows (c10bd7b1-e168-474e-923d-32699fb58498)
	}
}
