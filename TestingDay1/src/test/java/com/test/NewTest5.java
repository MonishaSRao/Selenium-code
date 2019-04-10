package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest5 {
  @Test
  public void testKeys() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b3a.00.39\\Documents\\chrome\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.cleartrip.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  WebElement from=driver.findElement(By.id("FromTag"));
	  Actions act1=new Actions(driver);
	  act1.sendKeys(from,"h").perform();
	  Thread.sleep(3000);
	  act1.sendKeys("y").perform();
	  Thread.sleep(3000);
	  act1.sendKeys("d").perform();
	  Thread.sleep(5000);
	  act1.sendKeys(Keys.ENTER).perform();
	  Thread.sleep(3000);
	  WebElement to=driver.findElement(By.id("ToTag"));
	  /*Actions act2=new Actions(driver);
	  act2.sendKeys(to,"b").perform();
	  Thread.sleep(3000);
	  act2.sendKeys("a").perform();
	  Thread.sleep(3000);
	  act2.sendKeys("n").perform();
	  Thread.sleep(3000);*/
	  to.sendKeys("b");
	  Thread.sleep(3000);
	  to.sendKeys("a");
	  Thread.sleep(3000);
	  to.sendKeys("n");
	  Thread.sleep(3000);
	  WebDriverWait wait= new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("ui-id-2"), By.className("list")));
	  WebElement ul=driver.findElement(By.id("ui-id-2"));
	  List<WebElement> list=ul.findElements(By.tagName("li"));
	  for(WebElement e:list)
	  {
		  if(e.getText().contains("BKK"))
		  {
		  e.click();
		  break;
	  }
		  //Assert.assertTrue(to.getAttribute("value").contains("BKK"));

  }
  }
}
  
