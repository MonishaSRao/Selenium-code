package com.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest6 {
  @Test
  public void testDropDown() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b3a.00.39\\Documents\\chrome\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.hdfcbank.com/");
	  driver.manage().window().maximize();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("document.getElementById('netsafe').click()");
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  String title=(String)js.executeScript("return document.title");
	  System.out.println(title);
	  driver.get("http://demowebshop.tricentis.com/login");
	  js.executeScript("document.getElementById('Email').value='askmail@gmail.com'");
  }
  
}
