package com.ust.org.ustmavendemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FaceBookTC1 
{
	
@Test
public void FACEBOOKTC1() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SARAVANAN R\\Desktop\\UST Global Appium\\Selenium\\chromedriver.exe");
	WebDriver myD=new ChromeDriver();
	myD.get("https://www.facebook.com");
	Thread.sleep(3000);
	myD.findElement(By.xpath("//input[@id='email']")).sendKeys("samsaravananr");
	Thread.sleep(3000);
	myD.findElement(By.xpath("//input[@id='email']")).sendKeys("samsaravananr");
	Thread.sleep(3000);
	myD.quit();

}

}
