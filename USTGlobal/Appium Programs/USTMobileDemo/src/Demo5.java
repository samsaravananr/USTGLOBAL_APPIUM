import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo5 extends DRIVERCALL{

	public static void main(String[] args) throws Exception 
	{

		
		AndroidDriver<AndroidElement> myD=BaseCall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		myD.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		Thread.sleep(2000);
		myD.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		myD.findElementById("android:id/checkbox").click();
		
		myD.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		myD.findElementById("android:id/edit").sendKeys("UST Global");
		Thread.sleep(5000);
		myD.findElementsByClassName("android.widget.Button").get(1).click();
		myD.closeApp();
		

	}

	
}
