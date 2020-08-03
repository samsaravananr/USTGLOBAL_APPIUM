package com.youtube.org.E2EUSTGLOBAL;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.YOUTUBEHOME;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MainTCYouTube extends BaseYouTube
{

	@Test
	public void TC002() throws Exception
	{
		service=startServer();
		AndroidDriver<MobileElement> myD=basecall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		YOUTUBEHOME youtube=new YOUTUBEHOME(myD);
		youtube.searchButton.click();
		Thread.sleep(7000);
		youtube.searchTextField.sendKeys("UST Global");
		Thread.sleep(3000);
		youtube.searchData.click();
		Thread.sleep(3000);
		youtube.ustVideo.click();
		Thread.sleep(10000);
		myD.closeApp();
		//service.stop();
		
	}
	

	
}
