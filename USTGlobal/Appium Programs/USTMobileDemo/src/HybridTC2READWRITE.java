import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class HybridTC2READWRITE extends HyBridAPPAGEREADWRITE{

	public static String vPath="C:\\Users\\SARAVANAN R\\Desktop\\UST Global Appium\\Selenium\\DataFrameworks.xls";
	
	public static void main(String[] args) throws Exception
	{
	
		xlRead(vPath);
		
		for (int i=1;i<xlRows;i++)
		{
		
		if(xData[i][1].equalsIgnoreCase("Y"))
		{
		vName=xData[i][2];	
			
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
		
		xData[i][4]=String.valueOf(vSum);
		
		if(vSum==Double.parseDouble(xData[i][3]))
		{
		//System.out.println("TOTAL PASSS");
		xData[i][5]="PASS";	
			
		}
		else
		{
			//System.out.println("TOTAL FAIL");
		xData[i][5]="FAIL";	
		takeScreenShot();
		xData[i][6]=vFile.getAbsolutePath();
		}
		
		System.out.println("TC006 - VERIFY GESTURES TC    "+VerifyGestures());
		Thread.sleep(3000);
		
		System.out.println("TC007 - VERIFY HYBRID TC      "+verifyHybrid());
		Thread.sleep(3000);
		
		System.out.println("TC008 - VERIFY CLOSE APP TC   "+CloseApp());
		Thread.sleep(3000);
		}
		}
		
		xlwrite("C:\\Users\\SARAVANAN R\\Desktop\\UST Global Appium\\Selenium\\USTResult.xls",xData);
		
		
	}
	
	


	}
	

	


