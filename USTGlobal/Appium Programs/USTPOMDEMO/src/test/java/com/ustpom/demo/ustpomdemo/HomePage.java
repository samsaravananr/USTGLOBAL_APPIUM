package com.ustpom.demo.ustpomdemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage 
{

	public HomePage(AppiumDriver myD)
	{
	PageFactory.initElements(new AppiumFieldDecorator(myD), this);
		
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	public WebElement Preferences;
	
}
