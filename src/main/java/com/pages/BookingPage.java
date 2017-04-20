package com.pages;

import java.util.Random;

import org.apache.log4j.Logger;

import com.objects.PageObjects;
import com.util.ExcelReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BookingPage extends BasePage {
	
	private static Logger log	= Logger.getLogger(BookingPage.class);

	public BookingPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	/**
	 * Close Popup
	 */
	public void closePopup() {
		log.info("Close Popup");
		click(PageObjects.bookingpage_popup_Close);
	}

	/**
	 * 
	 * Enter Source City
	 * 
	 */
	public void enterSourceCity() {
		
		log.info("Enter Source City");

		// Click on the Source city text box
		locateElement(PageObjects.bookingpage_tb_SourceCity).click();
		
		// Enter the city
		String soourceCity	= ExcelReader.readDataFromExcel().get("SourceCities").get(0);
		type(PageObjects.bookingpage_tb_EnterCityName, soourceCity);
		
		locateElement(PageObjects.bookingpage_list_SuggestedCities).click();

	}
	
	/**
	 * 
	 * Enter DestinationCities
	 */
	public void enterDestinationCity() {
		
		log.info("Enter Destination City");

		// Click on the Source city text box
		locateElement(PageObjects.bookingpage_tb_Destination).click();
		
		Random r = new Random();
		int index	= r.nextInt(ExcelReader.readDataFromExcel().get("DestinationCities").size());
		
		// Enter the city
		String soourceCity	= ExcelReader.readDataFromExcel().get("DestinationCities").get(index);
		type(PageObjects.bookingpage_tb_EnterCityName, soourceCity);
		
		locateElement(PageObjects.bookingpage_list_SuggestedCities).click();

	}

}
