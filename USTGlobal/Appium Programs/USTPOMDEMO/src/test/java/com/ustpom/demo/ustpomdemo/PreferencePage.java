package com.ustpom.demo.ustpomdemo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferencePage 
{
	
	public PreferencePage(AppiumDriver myD)
	{
		PageFactory.initElements(new AppiumFieldDecorator(myD), this);
	}

	@AndroidFindBy(className = "android.widget.Button")
	public List<WebElement> OKCANCELBUTTON;
}
