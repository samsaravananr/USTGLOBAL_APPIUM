import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebDemo extends BrowserCall{

	public static void main(String[] args) throws Exception 
	{
	
		
		AndroidDriver<AndroidElement> myD=BaseCall();
		myD.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		myD.get("https://www.google.com");
		System.out.println(myD.getTitle());
		Thread.sleep(2000);
		myD.quit();
		

	}

}
