package com.ust.org.ustmavendemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripTC1 
{

	@Test
	public void MAKEMYTRIPTC001() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SARAVANAN R\\Desktop\\UST Global Appium\\Selenium\\chromedriver.exe");
		WebDriver myD=new ChromeDriver();
		myD.get("https://www.makemytrip.com/");
		Thread.sleep(4000);
		System.out.println(myD.getTitle());
		myD.quit();
	}
}
