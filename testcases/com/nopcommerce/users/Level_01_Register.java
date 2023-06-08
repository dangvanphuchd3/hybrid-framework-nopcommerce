package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register {
	 // Yêu cầu:
	 // Viết làm sao có thể chạy được
	 // Không quan tâm tối ưu
	 // Có thể lặp lại nhiều step giống nhau
	
	// RY: Repeat yourself
	// DRY: Don't Repeat Yourself
	// Ưu điểm:
	// Code rất nhanh - Cho phép lặp lại nhiều lần
	// Có thể code vài case để thử 1 tool nào đó
	// POC: Proof of concept
	// Phù hợp dự án làm nhanh/ ngắn hạn/ thử nghiệm
	
	// Nhược điểm: 
	// Lặp lại rất nhiều step: Locator/ Hàm selenium
	// Phí bảo trì (maintain) tăng lên khi có sự thay đổi: Logic/ Business/ Thự viện/ UI
	// Không phù hợp với Framework
	// Không phù hợp để làm dự án auto có time dài/ mang lại nhiều value
	
	// Nguyên tắc: Có thế tái sử dụng/ tránh lặp lại
	 
	 WebDriver driver;
	 String projectPath = System.getProperty("user.dir");
	 
	 @BeforeClass
	 public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }
	  
	 @Test
	 public void Register_01_Empty_Data() {
		 driver.get("https://demo.nopcommerce.com/");
	 }
	  
	 @Test
	 public void Register_02_Invalid_Email() {
		  
	 }
	  
	 @Test
	 public void Register_03_Invalid_Password() {
		  
	 }
	  
	 @Test
	 public void Register_04_Incorrect_Confirm_Password() {
		  
	 }
	  
	 @Test
	 public void Register_05_Success() {
		  
	 }
	  
	 @AfterClass
	 public void afterClass() {
		 driver.quit();
	 }
}
