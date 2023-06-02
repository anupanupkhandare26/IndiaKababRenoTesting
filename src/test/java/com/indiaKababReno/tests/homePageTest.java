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
import com.indiaKababReno.pages.registrationPage;

@Listeners(BugReportListener.class)
public class homePageTest extends baseclass 
{
	homePage home;
	@BeforeMethod
	public void initializePage()
	{
		try {
		home=new homePage(driver);
		driver.get(utilityclass.readPFData("URL"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void verifySendButton()
	{try {
		String actResult = home.sendButtonIsDisplayed();
		Assert.assertEquals(actResult,utilityclass.readPFData("sendButton"), "Send Message is not displayed");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	@Test
	public void verifyHeaderIconsSection()
	{
		Assert.assertTrue(home.phoneIconDisplayed(), "Phone icon is not displayed");
	    Assert.assertTrue(home.facebookIconDisplayed(), "Facebook icon is not displayed");
	    Assert.assertTrue(home.instagramIconDisplayed(), "Instagram icon is not displayed");
	    Assert.assertTrue(home.yelpIconDisplayed(), "Yelp icon is not displayed");
	    Assert.assertTrue(home.isCartIconDisplayed(), "CartIcon icon is not displayed");
		
	}

}
