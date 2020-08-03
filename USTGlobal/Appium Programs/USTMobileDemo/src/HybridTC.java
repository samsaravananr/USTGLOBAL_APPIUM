import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class HybridTC extends HyBridTCPAGE{


	
	public static void main(String[] args) throws Exception
	{
	
			
		System.out.println("TC001 - OPEN APP              "+APPINIT());
		Thread.sleep(3000);
				
		System.out.println("TC002 - LOGIN VERIFY TOAST TC "+Login_Verify_TOAST());
		Thread.sleep(3000);
		
		System.out.println("TC003 - LOGIN TC              "+Login());
		Thread.sleep(3000);
		
		System.out.println("TC004 - ADD TO CART TC        "+AddToCart());
		Thread.sleep(3000);
		
		System.out.println("TC005 - VERIFY CART TC        "+VerifyCart());
		Thread.sleep(3000);
		
		System.out.println("TC006 - VERIFY GESTURES TC    "+VerifyGestures());
		Thread.sleep(3000);
		
		System.out.println("TC007 - VERIFY HYBRID TC      "+verifyHybrid());
		Thread.sleep(3000);
		
		System.out.println("TC008 - VERIFY CLOSE APP TC   "+CloseApp());
		Thread.sleep(3000);
		
		}
		
		
	}
	
	
	
	


