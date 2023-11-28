package com.nopcommerce.cookie;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageFactory.LoginPageObject;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Common_Register extends BaseTest {
	 private WebDriver driver;
	 private HomePageObject homePage;
	 private RegisterPageObject registerPage;
	 private pageObjects.LoginPageObject loginPage;
	 private String password;
	 
	 public static String firstName, lastName, emailAddress;
	 public static Set<Cookie> cookies;

	 @Parameters("browser")
	 @BeforeTest
	 public void beforeClass(String browserName) {
		 driver = getBrowserDriver(browserName);

		 homePage = PageGeneratorManager.getHomePage(driver);
		 
		 emailAddress = getEmailAddress();
		 password = "123456";
		 firstName = "John";
		 lastName = "Kennedy";

		 registerPage = homePage.clickToRegisterLink();

		 registerPage.enterToFirstNameTextbox(firstName);
		 registerPage.enterToLastNameTextbox(lastName);
		 registerPage.enterToEmailTextbox(emailAddress);
		 registerPage.enterToPasswordTextbox(password);
		 registerPage.enterToConfirmPasswordTextbox(password);

		 registerPage.clickToRegisterButton();

		 Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		 
		 registerPage.clickToHomePageLogo();
		 homePage = PageGeneratorManager.getHomePage(driver);

		 homePage.clickToLoginLink();
		 loginPage = PageGeneratorManager.getLoginPage(driver);

		 loginPage.enterToEmailTextbox(emailAddress);
		 loginPage.enterToPasswordTextbox(password);
		 loginPage.clickToLoginButton();
		 
		 cookies = registerPage.getBrowserCookies(driver);
		 
		 driver.quit();

	 }
}
