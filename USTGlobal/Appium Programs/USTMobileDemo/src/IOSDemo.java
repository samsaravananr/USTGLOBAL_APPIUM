import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class IOSDemo {

	public static void main(String[] args) throws Exception
	{
	
		
			DesiredCapabilities caps = DesiredCapabilities.iphone();
			caps.setCapability("appiumVersion", "1.17.1");
			caps.setCapability("deviceName","iPhone 8 Simulator");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("platformVersion","13.0");
			caps.setCapability("platformName", "iOS");
			caps.setCapability("browserName", "Safari");
			System.out.println("two");
			IOSDriver myD=new IOSDriver(new URL("https://saravananraghu:1ec1f618-3bb4-42ed-af99-edb64a294c69@ondemand.us-west-1.saucelabs.com:443/wd/hub"),caps);
			//IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
			System.out.println("three");
			myD.get("http://google.com");
			
			Thread.sleep(8000L);
			System.out.println(myD.getTitle());


	

	}

}
