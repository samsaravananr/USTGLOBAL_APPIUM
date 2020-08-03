import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DRIVERCALL {

	
	
	
		public static AndroidDriver<AndroidElement> BaseCall() throws Exception
		{
	
		AndroidDriver<AndroidElement> myD;
		
		File filelocation=new File("C:\\Users\\SARAVANAN R\\Mobile\\USTMobileDemo\\src\\ApiDemos-debug.apk");
		
		
		DesiredCapabilities DC=new DesiredCapabilities();
		
		DC.setCapability(MobileCapabilityType.DEVICE_NAME,"Sharonemulator");
		DC.setCapability(MobileCapabilityType.APP, filelocation.getAbsolutePath());
		
		myD=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),DC);
		
		return myD;
		
		}

	

}
