package com.indiaKababReno.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indiaKababReno.library.WaitUtils;
import com.indiaKababReno.library.baseclass;
import com.indiaKababReno.library.utilityclass;

public class registrationPage extends baseclass
{
	
	public registrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Registration Form Field
	@FindBy(xpath = "//form[@id='regsignupform']//input[@name='firstname']") private WebElement fullNameField;	
	@FindBy(xpath = "//form[@id='regsignupform']//input[@name='email']") private WebElement emailField;
	@FindBy(xpath = "//form[@id='regsignupform']//input[@name='contact']") private WebElement contactNumField;
	@FindBy(xpath = "//form[@id='regsignupform']//input[@name='password']") private WebElement pwdField;
	@FindBy(xpath = "//form[@id='regsignupform']//button[@name='register']") private WebElement createAccBtn;
	@FindBy(xpath = "//a[text()='Sign in']") private WebElement signInLink;

	//error Message for each field
	@FindBy(xpath = "//form[@id='regsignupform']//p[contains(@class,'customerror text-danger') and @id='regerfirstname']")private WebElement fullNameError;
	@FindBy(xpath = "//form[@id='regsignupform']//p[contains(@class,'customerror text-danger') and @id='regeremail']")private WebElement emailError;
	@FindBy(xpath = "//form[@id='regsignupform']//p[contains(@class,'customerror text-danger') and @id='regercontact']")private WebElement contactNumError;
	@FindBy(xpath = "//form[@id='regsignupform']//p[contains(@class,'customerror text-danger') and @id='regerpassword']")private WebElement passwordError;
	
	
	//Registration Action methods 
	
	public void enterRegistrationCredentials(String fullName,String email, String contact, String pwd)
	{  Actions act =new Actions(driver);
		utilityclass.scrollToElement(driver, createAccBtn);
		fullNameField.sendKeys(fullName);
		emailField.sendKeys(email);
		contactNumField.sendKeys(contact);
		pwdField.sendKeys(pwd);
		act.moveToElement(createAccBtn).click().perform();
				
	}
	
	//Error Message displays
	public boolean fullNameErrorMsgIsDisplayed()
	{
		WaitUtils.waitForElementToBeVisible(driver, fullNameError, Duration.ofSeconds(5));
		return fullNameError.isDisplayed();
	}
	public boolean emailErrorMsgIsDisplayed()
	{
		WaitUtils.waitForElementToBeVisible(driver, emailError, Duration.ofSeconds(5));
		return emailError.isDisplayed();
	}
	public boolean contactNumErrorMsgIsDisplayed()
	{
		WaitUtils.waitForElementToBeVisible(driver, contactNumError, Duration.ofSeconds(5));
		return contactNumError.isDisplayed();
	}
	public boolean passwordErrorMsgIsDisplayed()
	{
		WaitUtils.waitForElementToBeVisible(driver, passwordError, Duration.ofSeconds(5));
		return passwordError.isDisplayed();
	}
	
	//get current page URL
	public String verifyURL()
	{
		return driver.getCurrentUrl();
	}
}
