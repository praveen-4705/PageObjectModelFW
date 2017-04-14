package com.util;

import java.io.File;
import java.io.IOException;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void getScreenshot(WebDriver driver, String nameOfTheScreenShot) {
		
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destPath = System.getProperty("user.dir") + "/src/test/java/com/screenshot/"+nameOfTheScreenShot+".jpeg";

		try {
			FileUtil.copyFile(scrFile, new File(destPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
