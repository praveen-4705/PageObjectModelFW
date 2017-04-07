package com.pages;

import com.objects.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * This class contains all the HomePage related methods and utilities
 * 
 * @author praveen
 *
 */
public class HomePage extends BasePage{

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	/**
	 * 
	 * Select the country and language
	 * 
	 */
	public void selectCountryAndLanguage(){
		
		// Select country
		click(PageObjects.homepage_dd_CountrySelection);
		getElementList(PageObjects.homepage_cb_CountryName).get(1).click();
		
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
		
		// Click on login
		click(PageObjects.homepage_link_Login);
		
	}
	
	
	/**
	 * Navigate to booking page
	 * @return
	 */
	public BookingPage navigateToBookingPage(){
		
		// Click on menu toggle
		click(PageObjects.homepage_icon_MenuToggle);
		
		
		// Click on home
		click(PageObjects.homepage_link_Home);
		
		// Returns booking page object
		return new BookingPage(driver);
		
	}
}