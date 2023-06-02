package com.indiaKababReno.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.indiaKababReno.library.BugReportListener;
import com.indiaKababReno.library.baseclass;
import com.indiaKababReno.pages.homePage;
import com.indiaKababReno.pages.registrationPage;
import com.indiaKababReno.library.utilityclass;


@Listeners(BugReportListener.class)
public class registrationPageTest extends baseclass
{
	registrationPage rp;
	
	@BeforeMethod
	public void initializePage()
	{
		
		rp=new registrationPage(driver);
		try {
			
			driver.get(utilityclass.readPFData("registerationPageUrl"));
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	

	@Test(dataProvider="registrationCredentials",dataProviderClass = com.indiaKababReno.library.utilityclass.class)
	public void verifyRegistrationPage(String scenario,String fullName,String email, String contact, String pwd, String result)
	{
		rp.enterRegistrationCredentials(fullName, email, contact, pwd);
		
		if(scenario.equals("valid"))
		{	TCID=001;
			String actResult=rp.verifyURL();
			String expResult=result;
			Assert.assertEquals(actResult, expResult);
		}
		else if(scenario.equals("invalidEmail"))
		{TCID=002;
			boolean actResult=rp.emailErrorMsgIsDisplayed();
			Assert.assertEquals(actResult, true,"Email field Error Message Not Displayed!!!");
		}
		else if(scenario.equals("invalidNumber"))
		{TCID=003;
			boolean actResult=rp.contactNumErrorMsgIsDisplayed();
			Assert.assertEquals(actResult, true,"Contact field Error Message Not Displayed!!!");
			
		}
		else if(scenario.equals("shortPassword"))
		{TCID=004;
			boolean actResult=rp.passwordErrorMsgIsDisplayed();
			Assert.assertEquals(actResult, true,"Password field Error Message Not Displayed!!!");
		}
		else if(scenario.equals("existingCredentials"))
		{TCID=005;
			String actResult=rp.verifyURL();
			String expResult=result;
			Assert.assertEquals(actResult, expResult);	
		}
		else if(scenario.equals("invalidFormat"))
		{TCID=006;
			boolean emailResult=rp.emailErrorMsgIsDisplayed();
			Assert.assertEquals(emailResult, true,"Email field Error Message Not Displayed!!!");
			boolean contactResult=rp.contactNumErrorMsgIsDisplayed();
			Assert.assertEquals(contactResult, true,"Contact field Error Message Not Displayed!!!");
			boolean pwdResult=rp.passwordErrorMsgIsDisplayed();
			Assert.assertEquals(pwdResult, true,"Password field Error Message Not Displayed!!!");
		
		}
		else if(scenario.equals("longCredentials"))
		{TCID=007;
			String actResult=rp.verifyURL();
			String expResult=result;
			Assert.assertEquals(actResult, expResult);	
			
		}
		else if(scenario.equals("noContactNum"))
		{TCID=8;
			boolean actResult=rp.contactNumErrorMsgIsDisplayed();
			Assert.assertEquals(actResult, true,"Contact field Error Message Not Displayed!!!");
		
		}
		else if(scenario.equals("invalidEmailPasswordContactFormat"))
		{TCID=9;
			boolean emailResult=rp.emailErrorMsgIsDisplayed();
			Assert.assertEquals(emailResult, true,"Email field Error Message Not Displayed!!!");
			boolean contactResult=rp.contactNumErrorMsgIsDisplayed();
			Assert.assertEquals(contactResult, true,"Contact field Error Message Not Displayed!!!");
		
		}
		
	}

}
