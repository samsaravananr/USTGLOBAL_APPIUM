import java.net.URL;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.FileInputStream;

public class HyBridTCPAGE 
{
	public static String vFlag;
	public static AndroidDriver<AndroidElement> myD;
	public static String vProduct="Converse All Star";
	 

	public static String APPINIT() throws Exception
	{
		vFlag="FAIL";
		
		DesiredCapabilities DC=new DesiredCapabilities();
		DC.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		DC.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
		//APP Details
		DC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		DC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
		DC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		myD=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),DC);
		vFlag="PASS";
		
		return vFlag;
		
	}
	
	public static String Login() throws Exception
	{
		
		vFlag="FAIL";
		myD.findElementById("android:id/text1").click();
		myD.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
		myD.findElementByXPath("//android.widget.TextView[@text='Australia']").click();
		myD.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Sharon");
		myD.hideKeyboard();
		myD.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		myD.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		return vFlag="PASS";
		
	}
	
	public static String Login_Verify_TOAST() throws Exception
	{
		
		vFlag="";
		myD.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String vToast=myD.findElementByXPath("//android.widget.Toast[1]").getAttribute("text");
		//System.out.println(vToast);
		
		if(vToast.contains("Please enter your name"))
		{
			return vFlag="PASS";
		}
		else
		{
			return vFlag="FAIL";
		}
				
	}
	
	
	public static String AddToCart() throws Exception
	{
		myD.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\").instance(0))"));
		int vTotalItem=myD.findElementsById("com.androidsample.generalstore:id/productName").size();
		//System.out.println(vTotalItem);
		
		for (int i=0;i<vTotalItem;i++)
		{
			String vProd=myD.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			//System.out.println(vProd);
		
		
		if (vProd.contains(vProduct))
		{
			myD.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
			myD.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i+1).click();
			break;
		}
		}
		
		myD.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(4000);
		
		String ProductEXP=myD.findElementById("com.androidsample.generalstore:id/productName").getText();
		
		if(ProductEXP.equals(vProduct))
		{
			return vFlag="PASS";
		}
		
		else
		{
			return vFlag="FAIL";
		}
				 
	}
	
	public static String VerifyCart() throws Exception
	{
		
		String vPrice1=myD.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		String vPrice2=myD.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		String vTotal=myD.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		
		//System.out.println("Price 1" + vPrice1 + "   Price 2 "+vPrice2+ "    Total is "+vTotal);
		
		vPrice1=vPrice1.substring(1);
		vPrice2=vPrice2.substring(1);
		vTotal=vTotal.substring(1);
		
		double vSum=Double.parseDouble(vPrice1)+Double.parseDouble(vPrice2);
		
		if(vSum==Double.parseDouble(vTotal))
		{
			return "TOTAL MATCHES";
		}
		
		else
		{
			return "TOTAL DOES NOT MATCHE";
		}
		
		
		
	}
	
	public static String VerifyGestures() throws Exception
	{
		vFlag="FAIL";
		WebElement vEmail=myD.findElementByXPath("//*[@text='Send me e-mails on discounts related to selected products in future']");
		WebElement vAgree=myD.findElementById("com.androidsample.generalstore:id/termsButton");
		
		TouchAction touch=new TouchAction(myD);
		touch.tap(tapOptions().withElement(element(vEmail))).perform();
		
		touch.longPress(longPressOptions().withElement(element(vAgree)).withDuration(ofSeconds(5))).release().perform();
		
		myD.findElementByXPath("//*[@text='CLOSE']").click();
		
		myD.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
		return vFlag="PASS";
		
		
	}
	
	public static String verifyHybrid() throws Exception
	{
		vFlag="FAIL";
		Set<String> vcontextName =myD.getContextHandles();
		for(String vContext:vcontextName)
		{
			//System.out.println(vContext);
		}
		
		myD.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(3000);
		
		myD.findElementByName("q").sendKeys("samsaravananr@gmail.com");
		myD.findElementByName("q").sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		((AndroidDriver)myD).pressKey(new KeyEvent(AndroidKey.BACK));
		
		myD.context("NATIVE_APP");
		
		return vFlag="PASS";
		
	}
	
	public static String CloseApp() throws Exception
	{
		vFlag="FAIL";
		
		myD.quit();
		return vFlag="PASS";
	}
	
	
	
	
	
	
	
}
