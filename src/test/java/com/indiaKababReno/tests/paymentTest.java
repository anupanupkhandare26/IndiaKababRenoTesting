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
public class paymentTest extends baseclass
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
	
	@Test(dataProvider="preOrderCredentials",dataProviderClass = com.indiaKababReno.library.utilityclass.class)
	public void verifyPaymentMethod(String fullName,String email,String contact,String cardNum,String expiry,String cvv)
	{
		menu.clickOnMenu();
		menu.clickOnAddToCartIcon();
		menu.AddtoCartWindowButton();
		menu.clickOnProceedToCheckOutButton();
		menu.clickOnGuestCheckOutButton();
		menu.enterFullName(fullName);
		menu.enterEmailId(email);
		menu.enterContactNumber(contact);
		menu.enterCardNumber(cardNum);
		menu.enterExpiryDateNumber(expiry);
		menu.enterCVVNumber(cvv);
		menu.clickOnMakePaymentButton();
		String actPayementPage=driver.getCurrentUrl();
		Assert.assertEquals(actPayementPage,"https://indiakababreno.com/payment" );
	}

}
