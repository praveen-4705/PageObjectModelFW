package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {

	protected AppiumDriver<MobileElement> driver;

	public BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	/**
	 * Locating the elements using the give locator
	 * 
	 * @param by
	 * @return
	 */
	public MobileElement locateElement(By by) {

		MobileElement w = null;

		try {
			
			// locating the element
			w = driver.findElement(by);
		} catch (NoSuchElementException e) {

			e.printStackTrace();
		}
		
		// Returns the Mobile element
		return w;
	}
	
	/**
	 * Enter text in text box
	 * 
	 * @param by
	 * @param inputText
	 */
	public void type(By by, String inputText){
		
		// locate the element
		MobileElement m = locateElement(by);
		
		// Clear and Send text
		m.clear();
		m.sendKeys(inputText);
		
	}

}
