package com.testscripts;

import org.testng.annotations.Test;

import com.pages.HomePage;

public class TestSuite extends BaseTest{
	
	@Test
	public void testScript1(){
		
		HomePage homePage	= new HomePage(driver);
		
	}

}
