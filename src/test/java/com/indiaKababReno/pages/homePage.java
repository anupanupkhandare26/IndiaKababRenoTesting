package com.indiaKababReno.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indiaKababReno.library.baseclass;

public class homePage extends baseclass
{
	public homePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy() private WebElement ;
	
	//Top Header section
	@FindBy(xpath = "//ul[@class='contact_detail text-center text-lg-left']//i") private WebElement phoneIcon;
	@FindBy(xpath = "//ul[@class='contact_detail text-center text-lg-left']//a") private WebElement phoneNub;
	@FindBy(xpath = "(//ul[contains(@class,'social_icons')]//a[contains(@href,'facebook')])[1]") private WebElement fbIcon;
	@FindBy(xpath = "(//ul[contains(@class,'social_icons')]//a[contains(@href,'instagram')])[1]") private WebElement instaIcon;
	@FindBy(xpath = "(//ul[contains(@class,'social_icons')]//a[contains(@href,'yelp')])[1]") private WebElement yelpIcon;
	@FindBy(xpath = "//ul//a[contains(text(),'Login')]") private WebElement loginBtn;
	
	//Action methods on Top Header section
	
	public boolean phoneIconDisplayed()
	{
		return  phoneIcon.isDisplayed();
	}
	public boolean phoneNumb()
	{
		return phoneNub.isEnabled();
	}
	public boolean facebookIconDisplayed()
	{
		return  fbIcon.isDisplayed();
	}
	public boolean instagramIconDisplayed()
	{
		return  instaIcon.isDisplayed();
	}
	public boolean yelpIconDisplayed()
	{
		return  yelpIcon.isDisplayed();
	}
	public void clickOnLoginButton()
	{
		loginBtn.click();
	}
	
	//Header Navigate Menu
	@FindBy(xpath = "//img[@class='logo_dark_mrd']") private WebElement companyLogo ;	
	@FindBy(xpath = "//ul[@class='navbar-nav']//a[contains(text(),'Home')]") private WebElement homeLink;
	@FindBy(xpath = "//ul[@class='navbar-nav']//a[contains(text(),'About')]") private WebElement aboutLink;
	@FindBy(xpath = "//ul[@class='navbar-nav']//a[contains(text(),'Menu')]") private WebElement menuLink;
	@FindBy(xpath = "//ul[@class='navbar-nav']//a[contains(text(),'Gallery')]") private WebElement galleryLink;
	@FindBy(xpath = "//ul[@class='navbar-nav']//a[contains(text(),'reservation')]") private WebElement reservationLink;
	@FindBy(xpath = "//ul[@class='navbar-nav']//a[contains(text(),'Login')]") private WebElement loginLink;
	@FindBy(id = "cart_count") private WebElement cartCountIcon;
	
	//Action methods on Header Navigation Menu
	
	public void clickOnHome()
	{
		homeLink.click();
	}
	public void clickOnAbout()
	{
		aboutLink.click();
	}
	public void clickOnMenu()
	{
		menuLink.click();
	}
	public void clickOnGallery()
	{
		galleryLink.click();
	}
	public void clickOnReservation()
	{
		reservationLink.click();
	}
	public void clickOnLoginBtn()
	{
		loginLink.click();
	}
	public void clickOnCartIcon()
	{
		cartCountIcon.click();
	}
	public boolean isCartIconDisplayed()
	{
		return cartCountIcon.isDisplayed();
	}
	
	//Bottom Section of Site
	
	@FindBy(xpath = "//button[@type='button']//div[@class='tawk-text-truncate']") private WebElement sendMessageBtn;
	
	//Action methods On Send message button
	public String sendButtonIsDisplayed()
	{
		return sendMessageBtn.getText();
	}
	public void clickOnSendMessageButton()
	{
		sendMessageBtn.click();
	}

}
