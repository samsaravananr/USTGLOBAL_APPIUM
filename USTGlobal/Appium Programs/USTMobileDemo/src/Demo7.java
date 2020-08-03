import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo7 extends DRIVERCALL{

	public static void main(String[] args) throws Exception 
	{

		
		AndroidDriver<AndroidElement> myD=BaseCall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myD.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println(myD.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
		System.out.println(myD.findElementsByAndroidUIAutomator("new UiSelector().enabled(true)").size());
		myD.closeApp();
		
		
		
	}

	
}
