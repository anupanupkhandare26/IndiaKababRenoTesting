package com.indiaKababReno.library;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.indiaKababReno.library.*;

public class baseclass 
{
	public int TCID;
	public static WebDriver driver;
	public static Logger logs;
	
	
	@Parameters({"browsername"})
	@BeforeClass
	public static void initializeBrowser(String browser)
	{
		try {
		switch (browser.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
			break;

		default:
			Reporter.log("Please Enter the Valid browser name apart from : "+browser);
			break;
		}
		
		driver.manage().window().maximize();
		
		logs= LogManager.getLogger("India Kabab Reno Logs");
		
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	}
	
	@AfterClass
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			utilityclass.captureSS(TCID);
		}
		driver.quit();
	}

	
}
