import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebDemo2 extends BrowserCall{

	public static void main(String[] args) throws Exception 
	{
	
		
		AndroidDriver<AndroidElement> myD=BaseCall();
		myD.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		myD.get("https://www.google.com/");
		System.out.println(myD.getTitle());
		Thread.sleep(2000);
		
		myD.findElementByXPath("//*[@name='q']").sendKeys("samsaravananr");
		Thread.sleep(2000);
		myD.findElementByXPath("//*[@name='q']").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		System.out.println(myD.getTitle());
		
		JavascriptExecutor js=(JavascriptExecutor) myD;
		js.executeScript("window.scrollBy(0,2000)", "");
		
		
		
		  myD.findElementByXPath("//*[text()='More results']").click();
		  
		  Thread.sleep(5000);
		  
		  
		  js.executeScript("window.scrollBy(0,2000)", "");
		  
		  Thread.sleep(5000);
		  
		  //Clicking on Help Button
		  myD.findElementByXPath("//*[@id=\"fbar\"]/div[4]/span/div/a[1]").click();
		  
		  
		  System.out.println(myD.getTitle());
		   
		Thread.sleep(6000);
		myD.close();
		

	}

}
