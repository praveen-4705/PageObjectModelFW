package com.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.BookingPage;
import com.pages.HomePage;

public class TestSuite extends BaseTest {

	@Test
	public void testScript1() {
		// Open App
		HomePage homePage = new HomePage(driver);
		// Select country and language
		homePage.selectCountryAndLanguage();
		// Click on login
		homePage.clickOnLogin();
		Assert.assertTrue(false);
		// Navigate to booking page by clicking on Home link
		BookingPage bookingPage	= homePage.navigateToBookingPage();
		// Close popup
		bookingPage.closePopup();
		// Enter source city
		bookingPage.enterSourceCity();
		//Enter destination city
		bookingPage.enterDestinationCity();
	}

}
