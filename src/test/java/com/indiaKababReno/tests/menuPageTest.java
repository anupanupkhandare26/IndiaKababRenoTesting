package com.indiaKababReno.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.indiaKababReno.library.BugReportListener;
import com.indiaKababReno.library.baseclass;
import com.indiaKababReno.library.utilityclass;
import com.indiaKababReno.pages.homePage;
import com.indiaKababReno.pages.menuPage;

@Listeners(BugReportListener.class)
public class menuPageTest extends baseclass
{
	menuPage menu;
	
	@BeforeMethod
	public void initializePage()
	{
		menu=new menuPage(driver);
		
		try {
			
			driver.get(utilityclass.readPFData("menuPageUrl"));
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Test(enabled = false)
	public void verifyMenuTabs()
	{
		int actMenuSize=menu.getAllMenu().size();
		Assert.assertEquals(actMenuSize, 17,"Incorrect menu content for Menu Tab");
		
	}
	
	@Test(dataProvider="menuData",dataProviderClass = com.indiaKababReno.library.utilityclass.class)
	public void veriFyProductSizeOfEachMenu(String menuName, int noOfProducts)
	{
		String selectedMenuName=menu.selectMenu();
		if (selectedMenuName.equals(menuName)) {
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
		else if(selectedMenuName.equals(menuName))
		{
		int productSize=menu.getProductSizeOfEachMenu();
		Assert.assertEquals(productSize, noOfProducts,"Incorrect menu content for Menu Tab");
		}
	}
	

}
