package com.indiaKababReno.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.indiaKababReno.library.baseclass;
import com.indiaKababReno.library.utilityclass;
import com.indiaKababReno.library.BugReportListener;

@Listeners(BugReportListener.class)
public class sanityLinkTests extends baseclass {

	@BeforeMethod
	public void initialisePage() {
		try {

			driver.get(utilityclass.readPFData("URL"));
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(description = "Verify hyperlink and image link validity")
	public void testLinkValidation() {

		// Get all anchor tags on the page
		List<WebElement> anchorTags = driver.findElements(By.tagName("a"));
		for (WebElement anchorTag : anchorTags) {
			String href = anchorTag.getAttribute("href");
			if (href != null && !href.isEmpty()) {
				int responseCode = getHttpResponseCode(href);
				Assert.assertEquals(responseCode, 200, "Broken link found: " + href);
			}
		}

		// Get all image tags on the page
		List<WebElement> imageTags = driver.findElements(By.tagName("img"));
		for (WebElement imageTag : imageTags) {
			String src = imageTag.getAttribute("src");
			if (src != null && !src.isEmpty()) {
				int responseCode = getHttpResponseCode(src);
				Assert.assertEquals(responseCode, 200, "Broken image link found: " + src);
			}
		}
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
