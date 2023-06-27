package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_02_Static {
	
	 WebDriver driver;
	 BasePage basePage = BasePage.getBasePage();
	 String projectPath = System.getProperty("user.dir");
	 
	 @BeforeClass
	 public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }
	  
	 @Test
	 public void Register_01_Empty_Data() {
		 basePage.openUrl(driver, "https://demo.nopcommerce.com/");
		 
		 basePage.clickToElement(driver, "//a[@class='ico-register']");
		 
		 basePage.clickToElement(driver, "//button[@id='register-button']");
		 
		 Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		 Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		 Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		 Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		 Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
		 
	 }
	  
	 @Test
	 public void Register_02_Invalid_Email() {
		 basePage.openUrl(driver, "https://demo.nopcommerce.com/");
		 
		 basePage.clickToElement(driver, "//a[@class='ico-register']");
		 
		 basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "John");
		 basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Wick");
		 basePage.sendKeyToElement(driver, "//input[@id='Email']", "johwich@123@gmail.com");
		 basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		 basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		 
		 basePage.clickToElement(driver, "//button[@id='register-button']");
		 
		 Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
		 
	 }
	  
	 @Test
	 public void Register_03_Invalid_Password() {
		 basePage.openUrl(driver, "https://demo.nopcommerce.com/");
		 
		 basePage.clickToElement(driver, "//a[@class='ico-register']");
		 
		 basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "John");
		 basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Wick");
		 basePage.sendKeyToElement(driver, "//input[@id='Email']", "johwich112@gmail.com");
		 basePage.sendKeyToElement(driver, "//input[@id='Password']", "123");
		 basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
		 
		 basePage.clickToElement(driver, "//button[@id='register-button']");
		 
		 Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"), "Password must meet the following rules:\n"
		 		+ "must have at least 6 characters");
	 }
	  
	 @Test
	 public void Register_04_Incorrect_Confirm_Password() {
		 basePage.openUrl(driver, "https://demo.nopcommerce.com/");
		 
		 basePage.clickToElement(driver, "//a[@class='ico-register']");
		 
		 basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "John");
		 basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Wick");
		 basePage.sendKeyToElement(driver, "//input[@id='Email']", "johwich112@gmail.com");
		 basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		 basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
		 
		 basePage.clickToElement(driver, "//button[@id='register-button']");
		 
		 Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	 }
	  
	 @Test
	 public void Register_05_Success() {
		 basePage.openUrl(driver, "https://demo.nopcommerce.com/");
		 
		 basePage.clickToElement(driver, "//a[@class='ico-register']");
		 
		 basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "John");
		 basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Wick");
		 basePage.sendKeyToElement(driver, "//input[@id='Email']", getEmailAddress());
		 basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
		 basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		 
		 basePage.clickToElement(driver, "//button[@id='register-button']");
		 
		 Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }
	 
	 public String getEmailAddress() {
		 String name = "johnwick";
		 Random rad = new Random();
		 return name + rad.nextInt(9999) + "@gmail.com";
	 }
}
