package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest8 {
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b3a.00.39\\Documents\\chrome\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://demowebshop.tricentis.com/login");
		  driver.manage().window().maximize();
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}

	@Test(dataProvider="dp1")
	public void testValidUserDemoWebShop(String username,String password ) {
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.linkText("Log out")).click();
		driver.findElement(By.linkText("Log in")).click();
		
	}
	@DataProvider(name="dp1")
	public Object[][] provideData()
	{
		return NewTest7.dataDriven();
		

	}

}
