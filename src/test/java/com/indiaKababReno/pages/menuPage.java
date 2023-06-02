package com.indiaKababReno.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indiaKababReno.library.baseclass;

public class menuPage extends baseclass
{
	public menuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Payment WebElements
	@FindBy(xpath = "//a[@title='add to cart']") private WebElement addToCartButton;
	@FindBy(xpath = "//div[@id='welcomemenu']//button[@class='close']")private WebElement closeAddtoCartWindow;
	@FindBy(xpath = "//div[@id='welcomemenu']//button[@class='btn btn-sm btn-default']")private WebElement addtoCartWindowButton;
	@FindBy(xpath = "//div[@id='reloadme']//a[contains(text(),'Proceed To CheckOut')]")private WebElement proceedToCheckoutButton;
	@FindBy(xpath = "//div[@class='modal-content']//button[contains(text(),' Guest Checkout')]")private WebElement guestCheckOutButton;
	@FindBy(xpath = "//div[@class='modal-content']//button[contains(text(),' Register')]")private WebElement registerButton;
	@FindBy(xpath = "//div[@class='modal-content']//button[contains(text(),' Login')]")private WebElement loginButton;
	@FindBy(xpath = "//form[@id='payment-form']//input[contains(@name,'firstname')]")private WebElement fullNameField;
	@FindBy(xpath = "//form[@id='payment-form']//input[contains(@name,'email')]")private WebElement emailField;
	@FindBy(xpath = "//form[@id='payment-form']//input[contains(@name,'contact')]")private WebElement contactNumField;
	@FindBy(xpath = "//div[@class='card mt-4']//div[contains(@class,'input-group')]/input[@id='cardnumber']")private WebElement cardNumberField;
	@FindBy(xpath = "//div[@class='card mt-4']//div[contains(@class,'input-group')]/input[@id='expdata']")private WebElement expDateField;
	@FindBy(xpath = "//div[@class='form-group']//input[contains(@id,'cvc')]")private WebElement cvvNumberField;
	@FindBy(xpath = "//button[@id='card-button']")private WebElement makePaymentButton;
	//Interation's methods for Payment sections
	
	public void clickOnAddToCartIcon()
	{
		addToCartButton.click();
	}
	public void closeAddtoCartWindowButton()
	{
		closeAddtoCartWindow.click();
	}
	public void AddtoCartWindowButton()
	{
		addtoCartWindowButton.click();
	}
	public void clickOnProceedToCheckOutButton()
	{
		proceedToCheckoutButton.click();
	}
	public void clickOnGuestCheckOutButton()
	{
		guestCheckOutButton.click();
	}
	public void clickOnRegisterButton()
	{
		registerButton.click();
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public void enterFullName(String name)
	{
		fullNameField.sendKeys(name);
	}
	public void enterEmailId(String email)
	{
		emailField.sendKeys(email);
	}
	public void enterContactNumber(String contactNum)
	{
		contactNumField.sendKeys(contactNum);
	}
	public void enterCardNumber(String cardNum)
	{
		cardNumberField.sendKeys(cardNum);
	}
	public void enterExpiryDateNumber(String expiryDate)
	{
		expDateField.sendKeys(expiryDate);
	}
	public void enterCVVNumber(String cvvNum)
	{
		cvvNumberField.sendKeys(cvvNum);
	}
	public void clickOnMakePaymentButton()
	{
		makePaymentButton.click();
	}
	
	
	//WebElements of all the Menu Tabs present
	@FindBy(xpath = "//*[@id='tabmenubar']/li")private List<WebElement> menuTabs;
	@FindBy(xpath = "//div[@class='menu_product_info']")private List<WebElement> menuProductInfo;
	@FindBy(xpath = "//ul[@id='tabmenubar']/li/a[contains(text(),'Hot Appetizers')]")private WebElement menu;
	//Interation's methods for Menu sections
	
	public void clickOnMenu()
	{
		menu.click();
	}
	public List<WebElement> getAllMenu()
	{
		return menuTabs;
	}
	
	public String selectMenu()
	{
		String menuName = "";
		for (WebElement menuTab : menuTabs) {
	        menuName = menuTab.getText();
	        menuTab.click();    
	    }
		return menuName;
		
		
	}
	
	public int getProductSizeOfEachMenu() 
	{
		return menuProductInfo.size();
		
	}
	
	public void getProductInfo()
	{
		// Assert that submenus are related to the selected menu
		
		for (WebElement subMenu : menuProductInfo) {
            String subMenuText = subMenu.getText();
            
            // Example assertion: Assert.assertTrue(subMenuText.contains(menuName));
        }
	}

}
