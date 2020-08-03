import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo8 extends DRIVERCALL{

	public static void main(String[] args) throws Exception 
	{

		
		AndroidDriver<AndroidElement> myD=BaseCall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//myD.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//System.out.println(myD.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
		//System.out.println(myD.findElementsByAndroidUIAutomator("new UiSelector().enabled(true)").size());
		
		
		List<AndroidElement> HomeElements=myD.findElementsByClassName("android.widget.TextView");
		
		for (MobileElement elements:HomeElements)
		{
			//System.out.println(elements.getAttribute("text"));
			
			if(elements.getAttribute("text").equals("Views"))
			{
				elements.click();
				break;
			}
		}
		
		
		myD.closeApp();
		
		
		
	}

	
}
