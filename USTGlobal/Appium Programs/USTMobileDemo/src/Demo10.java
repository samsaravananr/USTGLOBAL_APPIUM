import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


public class Demo10 extends DRIVERCALL{

	public static void main(String[] args) throws Exception 
	{
		AndroidDriver<AndroidElement> myD=BaseCall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myD.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		myD.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		myD.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		
		myD.findElementByXPath("//*[@content-desc='10']").click();
		myD.findElementByXPath("//*[@content-desc='30']").click();
		
		Thread.sleep(5000);
		
		myD.closeApp();
		
	}

	
}
