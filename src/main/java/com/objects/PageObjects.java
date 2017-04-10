package com.objects;

import org.openqa.selenium.By;

public class PageObjects {
	
	/**
	 * 
	 * Naming conventions
	 * 
	 * all the variables are static and final
	 * 
	 * and all the variables names should start with page/screen name
	 * after that we need to give type of the element
	 * after that we need to specify the element name
	 * 
	 * Ex: login_tb_Username
	 * 
	 */
	
	public static final By homepage_dd_CountrySelection		= By.id("selected_country_wrapper");
	public static final By homepage_cb_CountryName			= By.id("country_radio");
	public static final By homepage_cb_LanguageName			= By.id("selection_indicator");
	public static final By homepage_btn_Continue			= By.id("continueButton");
	public static final By homepage_link_Login				= By.id("login");
	public static final By homepage_icon_MenuToggle			= By.className("android.widget.ImageButton");
	public static final By homepage_link_Home				= By.id("menu_text");
	
	public static final By bookingpage_popup_Close			= By.className("android.view.View");
	public static final By bookingpage_tb_SourceCity		= By.id("cityName1");
	public static final By bookingpage_tb_Destination		= By.id("cityName2");
	public static final By bookingpage_tb_EnterCityName		= By.id("search_src_text");
	public static final By bookingpage_list_SuggestedCities		= By.id("citySuggest");
	
	

}
