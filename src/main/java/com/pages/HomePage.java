package com.pages;


import com.objects.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * This class contains all the HomePage related methods and utilities
 * 
 * @author praveen
 *
 */
public class HomePage extends BasePage{
	
//	private static Logger log	= Logger.getLogger(HomePage.class);

	public HomePage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	/**
	 * 
	 * Select the country and language
	 * 
	 */
	public void selectCountryAndLanguage(){
		
//		log.info("Select the Country");
		// Select country
		//click(PageObjects.homepage_dd_CountrySelection);
		waitForAnElement(PageObjects.homepage_cb_CountryName);
		getElementList(PageObjects.homepage_cb_CountryName).get(1).click();
		
//		log.info("Select Language");
		// Select the language
		click(PageObjects.homepage_cb_LanguageName);
		
		// Click on Continue
		click(PageObjects.homepage_btn_Continue);
	}
	
	/**
	 * 
	 * Click on login
	 */
	public void clickOnLogin(){
		
//		log.info("Click on Login");
		// Click on logi
		click(PageObjects.homepage_link_Login);
		
	}
	
	
	/**
	 * Navigate to booking page
	 * @return
	 */
	public BookingPage navigateToBookingPage(){
		
//		log.info("Navigate to Booking Page");
		// Click on menu toggle
		click(PageObjects.homepage_icon_MenuToggle);
		
		
		// Click on home
		click(PageObjects.homepage_link_Home);
		
		// Returns booking page object
		return new BookingPage(driver);
		
	}
}
