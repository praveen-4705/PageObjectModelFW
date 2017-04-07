package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void type(By by, String inputText) {

		// locate the element
		MobileElement m = locateElement(by);

		// Clear and Send text
		m.clear();
		m.sendKeys(inputText);

	}

	/**
	 * Click on element
	 * 
	 * @param by
	 */
	public void click(By by) {

		waitForElementPresense(by);

		MobileElement w = locateElement(by);

		w.click();
	}

	/**
	 * Wait for the element to be loaded in the screen
	 * 
	 * @param by
	 */
	public void waitForElementPresense(By by) {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
	/**
	 * Get the visible elements list
	 * 
	 * @param by
	 * @return
	 */
	public List<WebElement> getElementList(By by) {

		List<MobileElement> elements = driver.findElements(by);
		List<WebElement> visibleElements = new ArrayList<WebElement>();

		for (int i = 0; i < elements.size(); i++) {

			if (elements.get(i).isDisplayed()) {
				visibleElements.add(elements.get(i));
			}

		}

		return visibleElements;
	}

}
