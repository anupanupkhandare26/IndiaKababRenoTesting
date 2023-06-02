package com.indiaKababReno.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.indiaKababReno.library.BugReportListener;
import com.indiaKababReno.library.WaitUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(BugReportListener.class)
public class WebsiteBugTests {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void goToUrl() {
		driver.get("https://indiakababreno.com/menu");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		// Quit the WebDriver and close the browser
		driver.quit();
	}

	@Test(enabled = false)
	public void testEmptyCartMessage() {

		WebElement cartIcon = driver
				.findElement(By.xpath("//i[@class='linearicons-cart']"));
		cartIcon.click();
		WebElement cartMessage = driver
				.findElement(By.xpath("//div[@class='order_review']//h4[text()='Cart is Empty']"));
		Assert.assertTrue(cartMessage.isDisplayed(), "Empty cart message is not displayed.");
	}

	@Test(enabled = false)
	public void testBrokenImage() {

		WebElement image = driver.findElement(By.tagName("object"));
		String imageUrl = image.getAttribute("data");
		Assert.assertTrue(isImageAccessible(imageUrl), "Image is broken: " + imageUrl);
	}

	@Test(enabled = false)
	public void testContactNumberLink() {

		WebElement contactNumberLink = driver.findElement(By.cssSelector("ul.contact_detail a[href^='tel:']"));
		Assert.assertNotNull(contactNumberLink.getAttribute("href"), "Contact number link is missing or invalid.");
	}

	@Test(enabled = false)
	public void testSocialMediaLinks() {

		WebElement facebookLink = driver
				.findElement(By.cssSelector("ul.social_icons a[href^='https://www.facebook.com/']"));
		WebElement instagramLink = driver
				.findElement(By.cssSelector("ul.social_icons a[href^='https://www.instagram.com/']"));
		WebElement yelpLink = driver.findElement(By.cssSelector("ul.social_icons a[href^='https://www.yelp.com/']"));

		Assert.assertNotNull(facebookLink.getAttribute("href"), "Facebook link is missing or invalid.");
		Assert.assertNotNull(instagramLink.getAttribute("href"), "Instagram link is missing or invalid.");
		Assert.assertNotNull(yelpLink.getAttribute("href"), "Yelp link is missing or invalid.");
	}

	@Test(enabled = false)
	public void testLoginLink() {

		WebElement loginLink = driver
				.findElement(By.cssSelector("ul.header_list a[href='https://indiakababreno.com/login']"));
		Assert.assertNotNull(loginLink.getAttribute("href"), "Login link is missing or invalid.");
	}

	@Test(enabled = false)
	public void testLogoImage() {

		WebElement logoImage = driver.findElement(By.cssSelector("img.logo_dark_mrd"));
		String imageUrl = logoImage.getAttribute("src");
		Assert.assertTrue(isImageAccessible(imageUrl), "Logo image is not accessible: " + imageUrl);
	}
	
	@Test(enabled = false)
	public void verifyTestimonialSectionDisplayed() {
	    
	    WebElement testimonialSection = driver.findElement(By.xpath("//div[@class='section bg_redon']"));
	    Assert.assertTrue(testimonialSection.isDisplayed(), "Testimonial section is not displayed.");
	}
	@Test(enabled = false)
    public void testBookTableForm() {
        
        driver.findElement(By.id("reservation")).click();

        // Fill in the form fields
        WebElement nameInput = driver.findElement(By.cssSelector("input[name='name']"));
        nameInput.sendKeys("John Doe");

        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
        emailInput.sendKeys("johndoe@example.com");

        WebElement timeInput = driver.findElement(By.cssSelector("input[name='time']"));
        timeInput.sendKeys("08:00 PM");

        WebElement phoneInput = driver.findElement(By.cssSelector("input[name='phone']"));
        phoneInput.sendKeys("1234567890");

        WebElement dateInput = driver.findElement(By.cssSelector("input[name='date']"));
        dateInput.sendKeys("2023-06-10");

        WebElement personSelect = driver.findElement(By.cssSelector("select[name='person']"));
        personSelect.sendKeys("2");

        WebElement submitButton = driver.findElement(By.cssSelector("a[name='submit']"));
        submitButton.click();

        // Assert the success message
        WebElement successMessage = driver.findElement(By.id("response"));
        Assert.assertEquals(successMessage.getText(), "Your reservation has been submitted.");

        // Assert that required fields are filled
        Assert.assertTrue(nameInput.getAttribute("value").equals("John Doe"));
        Assert.assertTrue(emailInput.getAttribute("value").equals("johndoe@example.com"));
        Assert.assertTrue(timeInput.getAttribute("value").equals("08:00 PM"));
        Assert.assertTrue(phoneInput.getAttribute("value").equals("1234567890"));
        Assert.assertTrue(dateInput.getAttribute("value").equals("2023-06-10"));
        Assert.assertTrue(personSelect.getAttribute("value").equals("2"));

        // Assert that error messages are not displayed for valid inputs
        WebElement nameError = driver.findElement(By.id("ename"));
        Assert.assertTrue(!nameError.isDisplayed());

        WebElement emailError = driver.findElement(By.id("eemail"));
        Assert.assertTrue(!emailError.isDisplayed());

        WebElement timeError = driver.findElement(By.id("etime"));
        Assert.assertTrue(!timeError.isDisplayed());

        WebElement phoneError = driver.findElement(By.id("ephone"));
        Assert.assertTrue(!phoneError.isDisplayed());

        WebElement dateError = driver.findElement(By.id("edate"));
        Assert.assertTrue(!dateError.isDisplayed());

        WebElement personError = driver.findElement(By.id("eperson"));
        Assert.assertTrue(!personError.isDisplayed());

        // Additional assertions can be added to validate the form behavior
        // For example, assert that invalid inputs show appropriate error messages
    }

	@Test(enabled = false)
	public void verifyTestimonialHeading() {
	    
	    WebElement testimonialHeading = driver.findElement(By.xpath("//div[@class='section bg_redon']//h2[text()='Our customers Say!']"));
	    WebElement testimonialSubHeading = driver.findElement(By.xpath("//div[@class='section bg_redon']//span[@class='sub_heading font_style1']"));
	    
	    Assert.assertTrue(testimonialHeading.isDisplayed(), "Testimonial heading is not displayed.");
	    Assert.assertTrue(testimonialSubHeading.isDisplayed(), "Testimonial subheading is not displayed.");
	    Assert.assertEquals(testimonialHeading.getText(), "Our customers Say!", "Testimonial heading text is incorrect.");
	    Assert.assertEquals(testimonialSubHeading.getText(), "Testimonial", "Testimonial subheading text is incorrect.");
	}

	@Test(enabled = false)
	public void verifyTestimonialBoxes() {
	    
	    List<WebElement> testimonialBoxes = driver.findElements(By.cssSelector("div.testimonial_box"));

	    Assert.assertEquals(testimonialBoxes.size(), 6, "Incorrect number of testimonial boxes.");

	    for (WebElement testimonialBox : testimonialBoxes) {
	        WebElement authorImg = testimonialBox.findElement(By.cssSelector("div.author_img img"));
	        WebElement authorName = testimonialBox.findElement(By.cssSelector("div.author_name h5"));
	        WebElement authorRole = testimonialBox.findElement(By.cssSelector("div.author_name span"));
	        WebElement testimonialDesc = testimonialBox.findElement(By.cssSelector("div.testimonial_desc p"));

	        Assert.assertTrue(authorImg.isDisplayed(), "Author image is not displayed.");
	        Assert.assertTrue(authorName.isDisplayed(), "Author name is not displayed.");
	        Assert.assertTrue(authorRole.isDisplayed(), "Author role is not displayed.");
	        Assert.assertTrue(testimonialDesc.isDisplayed(), "Testimonial description is not displayed.");

	        String imgSrc = authorImg.getAttribute("src");
	        String imgAlt = authorImg.getAttribute("alt");

	        Assert.assertNotNull(imgSrc, "Image source is null.");
	        Assert.assertFalse(imgSrc.isEmpty(), "Image source is empty.");
	        Assert.assertNotNull(imgAlt, "Image alt text is null.");
	        Assert.assertFalse(imgAlt.isEmpty(), "Image alt text is empty.");

	        // Additional assertions for the image source and alt text can be added here
	        // For example, you can assert that the image source contains a specific domain or part of the URL
	        // and verify if the alt text is meaningful and descriptive.
	    }
	}
	
	@Test(enabled = false)
    public void validateGalleryImages() throws InterruptedException {
        // Navigate to the page

        // Find the gallery section
        WebElement gallerySection = driver.findElement(By.id("gallery"));


		//WaitUtils.waitForElementToBeVisible(driver, gallerySection, Duration.ofSeconds(5));
		Thread.sleep(5000);
        // Verify the heading
        WebElement heading = gallerySection.findElement(By.tagName("h2"));
        Assert.assertEquals(heading.getText(), "Our Sweet Dishes!", "Incorrect heading text");

        // Find all gallery items
        List<WebElement> galleryItems = gallerySection.findElements(By.className("grid_item"));

        // Verify the number of gallery items
        Assert.assertEquals(galleryItems.size(), 12, "Incorrect number of gallery items");

        // Verify the image source and alt text for each gallery item
        for (WebElement galleryItem : galleryItems) {
            WebElement imageLink = galleryItem.findElement(By.tagName("a"));
            String imageSource = imageLink.getAttribute("href");
            String altText = imageLink.findElement(By.tagName("img")).getAttribute("alt");

            Assert.assertNotNull(imageSource, "Gallery image source is missing");
            Assert.assertNotNull(altText, "Gallery image alt text is missing");
        }
    }
	
	@Test
	public void testMenuNavigation() {
	    // Test navigation within the menu
	    WebElement menuTab1 = driver.findElement(By.id("18-tab"));
	    WebElement menuTab2 = driver.findElement(By.id("19-tab"));
	    WebElement menuContent = driver.findElement(By.id("mainpro"));

	    menuTab1.click();
	    Assert.assertTrue(menuTab1.getAttribute("class").contains("active"), "Menu Tab 1 is not active");
	    Assert.assertTrue(menuContent.getText().contains("Hot Appetizers"), "Incorrect menu content for Menu Tab 1");

	    menuTab2.click();
	    Assert.assertTrue(menuTab2.getAttribute("class").contains("active"), "Menu Tab 2 is not active");
	    Assert.assertTrue(menuContent.getText().contains("Cold Appetizers"), "Incorrect menu content for Menu Tab 2");

	    // Test navigating back and forth between different tabs
	    menuTab1.click();
	    Assert.assertTrue(menuTab1.getAttribute("class").contains("active"), "Menu Tab 1 is not active after navigating back");
	    Assert.assertTrue(menuContent.getText().contains("Hot Appetizers"), "Incorrect menu content for Menu Tab 1 after navigating back");

	    menuTab2.click();
	    Assert.assertTrue(menuTab2.getAttribute("class").contains("active"), "Menu Tab 2 is not active after navigating back");
	    Assert.assertTrue(menuContent.getText().contains("Cold Appetizers"), "Incorrect menu content for Menu Tab 2 after navigating back");

	    // Test clicking on a specific menu item
	    WebElement menuItem1 = driver.findElement(By.xpath("//div[@id='18']//div[@class='tab-pane fade show active']//div[@class='food-menu-detail'][1]"));
	    menuItem1.click();
	    // Add assertions to verify the details of the clicked menu item

	    // Test adding the menu item to the cart
	    WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
	    addToCartButton.click();
	    // Add assertions to verify that the menu item is added to the cart

	    // Test removing the menu item from the cart
	    WebElement removeFromCartButton = driver.findElement(By.id("remove-from-cart-button"));
	    removeFromCartButton.click();
	    // Add assertions to verify that the menu item is removed from the cart
	}


	private boolean isImageAccessible(String imageUrl) {
		List<WebElement> imageTags = driver.findElements(By.tagName("img"));
		for (WebElement imageTag : imageTags) {
			String src = imageTag.getAttribute("src");
			if (src != null && !src.isEmpty()) {
				int responseCode = getHttpResponseCode(src);
				Assert.assertEquals(responseCode, 200, "Broken image link found: " + src);
				// Implement the logic to check if the image is accessible
				// You can send an HTTP request to the image URL and check the response code
				// Placeholder implementation, modify as per your requirements
			}
		}
		return true;
	}

	private int getHttpResponseCode(String url) {
		int responseCode = 0;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			responseCode = connection.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseCode;
	}
}