package Support;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScrollFun
{
	static AndroidDriver<MobileElement> myD;
	
	public ScrollFun(AndroidDriver<MobileElement> myD)
	{
		this.myD=myD;
	}

	public static void ScrollText(String vText)
	{
		myD.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+vText+"\"));");
	}
	
}