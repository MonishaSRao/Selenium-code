package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewTest9 {
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b3a.00.39\\Documents\\chrome\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/login");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html");
		//htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/report1.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("host","LocalHost Training LKM");
		reports.setSystemInfo("username","monisha.srinath");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Report for Demo web shop");
	}
	@Test
	public void testPass(){
		logger=reports.createTest("test Pass");
		logger.log(Status.PASS,"This test has passed");
	}
	@Test
	public void testFail(){
		logger=reports.createTest("test fail");
		driver.findElement(By.id("Email")).sendKeys("askmail@email.com");
		driver.findElement(By.id("pass")).sendKeys("askmail@gmail.com");
		//Assert.assertTrue(false);
	}
@Test
public void testSkip(){
	logger=reports.createTest("test skip");
	throw new SkipException("This test is skipped");
}
@AfterMethod
public void afterMethod(ITestResult result){
	if(result.getStatus()==ITestResult.FAILURE)
	{
		logger.log(Status.FAIL,"This test "+result.getMethod().getMethodName()+" has failed");
		TakesScreenshot capture=(TakesScreenshot) driver;
		File src=capture.getScreenshotAs(OutputType.FILE);
		String capturePath=System.getProperty("user.dir")+"/extent-reports/capture/"+result.getMethod().getMethodName()+".png";
		try{
			FileUtils.copyFile(src, new File(capturePath));
			logger.addScreenCaptureFromPath(capturePath,"Demo Web Shop Screen");
			logger.log(Status.FAIL,result.getThrowable().getMessage());
		}
		 catch(IOException e)
		  {
		  e.printStackTrace();
		  }
		  }
		  else if(result.getStatus()==ITestResult.SKIP)
		  {
		  logger.log(Status.SKIP,MarkupHelper.createLabel("This test "+result.getMethod().getMethodName()+"is skipped",ExtentColor.INDIGO));
		  }
		  }
		  @AfterTest
		  public void afterTest() {
		  reports.flush();
		  driver.close();
		  }
		}