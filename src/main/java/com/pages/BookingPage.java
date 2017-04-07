package com.pages;

import com.objects.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BookingPage extends BasePage{

	public BookingPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	/**
	 * Close Popup
	 */
	public void closePopup(){
		click(PageObjects.bookingpage_popup_Close);
	}

}
