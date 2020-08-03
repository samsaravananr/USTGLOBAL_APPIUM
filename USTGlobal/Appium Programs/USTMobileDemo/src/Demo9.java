import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


public class Demo9 extends DRIVERCALL{

	public static void main(String[] args) throws Exception 
	{
		AndroidDriver<AndroidElement> myD=BaseCall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myD.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		WebElement EL=myD.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		TouchAction touch=new TouchAction(myD);
		touch.tap(tapOptions().withElement(element(EL))).perform();
		Thread.sleep(2000);
		myD.findElementByXPath("//*[@text='1. Custom Adapter']").click();
		WebElement people=myD.findElementByXPath("//*[@text='People Names']");
		
		touch.longPress(longPressOptions().withElement(element(people)).withDuration(ofSeconds(5))).release().perform();
	
		Thread.sleep(2000);
		Boolean vTitle=myD.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed();
		
		if(vTitle.equals(true))
		{
			System.out.println("Test Case PASS");
		}
		else
		{
			System.out.println("Test Case FAIL");
		}
		
		myD.closeApp();
		
	}

	
}
