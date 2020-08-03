import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


public class Demo17 extends DRIVERCALL{

	public static void main(String[] args) throws Exception 
	{
		AndroidDriver<AndroidElement> myD=BaseCall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		System.out.println(myD.getCurrentPackage());
		System.out.println(myD.currentActivity());
		System.out.println(myD.getOrientation());
		
		System.out.println(myD.getContext());
		
		
		System.out.println(myD.isDeviceLocked());
		
		//myD.hideKeyboard();
		
		
		myD.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		((AndroidDriver)myD).pressKey(new KeyEvent(AndroidKey.BACK));
		((AndroidDriver)myD).pressKey(new KeyEvent(AndroidKey.HOME));
		
		
	}

	
}
