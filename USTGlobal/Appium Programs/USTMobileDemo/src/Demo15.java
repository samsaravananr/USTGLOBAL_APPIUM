import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.URL;


public class Demo15 extends DRIVERCALL{

	public static void main(String[] args) throws Exception 
	{
		
		DesiredCapabilities DC=new DesiredCapabilities();
		
		//Environments Details
		DC.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//DC.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
		
		//REAL DEVICE
		DC.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		
		
		//APP Details
		DC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.youtube");
		DC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.youtube.HomeActivity");
		
		
		AndroidDriver<AndroidElement> myD=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),DC);

		
		

		
	}

	
}
