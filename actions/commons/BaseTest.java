package commons;

import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected final Logger log;
	
	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}
	
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		/* Dùng với if else
		if (browserName.equalsIgnoreCase("Chrome")) {
			 System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")){
			 System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			 driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Opera")){
			 System.setProperty("webdriver.opera.driver", projectPath + "\\browserDrivers\\operadriver.exe");
			 driver = new OperaDriver();
		} else {
			throw new RuntimeException("Browser name is not valid.");
		}
		*/

		switch (browserList) {
		case CHROME:
			 // System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			 // driver = new ChromeDriver();

			// 4.x
			// WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();

			// 5.x
			// Tự tải chromedriver tương ứng với Chrome browser + khởi tạo driver lên
			// driver = WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			 // System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			 // driver = new FirefoxDriver();
			// driver = WebDriverManager.firefoxdriver().create();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			 // System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			 // driver = new FirefoxDriver();
			// driver = WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser name is not valid.");
		}

		 driver.get(url);
		 driver.manage().window().maximize();
		 // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		 return driver;
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser name is not valid.");
		}

		 driver.get("https://demo.nopcommerce.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		 return driver;
	}

	protected String getEmailAddress() {
		 String name = "johnwick";
		 Random rad = new Random();
		 return name + rad.nextInt(9999) + "@gmail.com";
	}

	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("------------------ PASSED ------------------");
		} catch (Throwable e) {
			log.info("------------------ FAILED ------------------");
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}
	
	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("------------------ PASSED ------------------");
		} catch (Throwable e) {
			log.info("------------------ FAILED ------------------");
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}
	
	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("------------------ PASSED ------------------");
		} catch (Throwable e) {
			log.info("------------------ FAILED ------------------");
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}
	
	protected void closeBrowser() {
		driver.quit();
	}
}
