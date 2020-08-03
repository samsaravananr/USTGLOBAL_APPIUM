import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo3 extends DRIVERCALL{

	public static void main(String[] args) throws Exception 
	{
	
		AndroidDriver<AndroidElement> myD=BaseCall();
		
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Boolean vDev=myD.isDeviceLocked();
		
		if(vDev.equals("true"))
		{
			myD.unlockDevice();
		}
		
		myD.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		//Object[@property='value']

	}

}
