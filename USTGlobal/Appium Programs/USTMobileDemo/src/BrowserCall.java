import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

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


public class BrowserCall {

	public static AndroidDriver<AndroidElement> BaseCall() throws Exception 
	{
		
		DesiredCapabilities DC=new DesiredCapabilities();
		
		//Environments Details
		//DC.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//DC.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
		
		//REAL DEVICE
		DC.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
		DC.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		DC.setCapability("chromedriverExecutable", "C:\\Users\\SARAVANAN R\\Desktop\\UST Global Appium\\Appium Client\\ChromeDriver 69\\chromedriver.exe");
		DC.setCapability("appium:chromeOptions",ImmutableMap.of("w3c",false));
		
		
		
		
		AndroidDriver<AndroidElement> myD=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),DC);

		return myD;
		

		
	}

	
}
