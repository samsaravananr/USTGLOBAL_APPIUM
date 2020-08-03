package com.ustpom.demo.ustpomdemo;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MainTC extends DRIVERCALL
{
	
	@Test
	public void MainTC001() throws Exception
	{
		
	AndroidDriver<AndroidElement> myD= BaseCall();
	myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	HomePage homepage=new HomePage(myD);
	PreferencePage preferencePage=new PreferencePage(myD);
		
		homepage.Preferences.click();
		myD.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		myD.findElementById("android:id/checkbox").click();
		myD.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		myD.findElementById("android:id/edit").sendKeys("samsaravananr");
		
		
		//myD.findElementsByClassName("android.widget.Button").get(1).click();
		preferencePage.OKCANCELBUTTON.get(1).click();
		
		Thread.sleep(5000);
		myD.closeApp();



	}

}
