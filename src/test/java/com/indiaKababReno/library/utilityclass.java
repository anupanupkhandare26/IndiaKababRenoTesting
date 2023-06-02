package com.indiaKababReno.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;


public class utilityclass extends baseclass
{

	//Read Properties value from configuration file
	public static String readPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//TestData//config.properties");
		Properties prop=new Properties();
		prop.load(file);
		String value=prop.getProperty(key);
		return value;
	}
	
	//To capture Failed test cases
	public static void captureSS(int TCID) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//FailedTestcaseScreenshot//FailedTestCase_"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}

	//Data provider for login functionality
	@DataProvider(name ="loginCredentials")
	public static Object[][] getLoginData() throws IOException
	{
		XLUtility excel= new XLUtility(System.getProperty("user.dir")+"//TestData//Testdata.xlsx");
		Object data[][]=excel.twoDArray("loginCredentials");
		return data;
	}

	//Data provider for Registration Page
	@DataProvider(name ="registrationCredentials")
	public static Object[][] getRegistrationData() throws IOException
	{
		XLUtility excel= new XLUtility(System.getProperty("user.dir")+"//TestData//Testdata.xlsx");
		Object data[][]=excel.twoDArray("registrationCredentials");
		return data;
	}
	
	@DataProvider(name ="menuData")
	public static Object[][] getMenuData() throws IOException
	{
		return new Object[][]
				{
			{"Hot Appetizers",10},
			{"Cold Appetizers",4},
			{"Soups And Salads",6},
			{"Chicken",15},
			{"Lamb",8},
			{"Beef",6},
			{"Seafood",11},
			{"Vegetarian",21},
			{"Tandoori Specialities",9},
			{"Dosas",6},
			{"Regional Dishes",4},
			{"Rice Specialities",6},
			{"Fresh Baked Indian Breads",19},
			{"Side Dishes",9},
			{"Desserts",7},
			{"House Drinks",8},
			{"Dinner for One and Two",4}
				};
	}
	@DataProvider(name="preOrderCredentials")
	public static Object[][] getPreOrderCredentials()
	{
		return new Object[][]
				{
				{"John Doe", "johndoe@example.com", "1234567890", "4111111111111111", "12/23", "123"},
		        {"Jane Smith", "janesmith@example.com", "9876543210", "5555555555554444", "06/24", "456"},
		        {"Mike Johnson", "mikejohnson@example.com", "5554443333", "378282246310005", "09/22", "789"}
				};
	}
	
	//Scroll Upto Method
	 public static void scrollToElement(WebDriver driver, WebElement element) {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
	    }

}
