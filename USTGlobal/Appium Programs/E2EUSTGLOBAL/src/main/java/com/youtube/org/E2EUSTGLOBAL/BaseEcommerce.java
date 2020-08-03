package com.youtube.org.E2EUSTGLOBAL;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseEcommerce 
{
	
	public static AndroidDriver<MobileElement> myD;
	public static AppiumDriverLocalService service;
	
	
	public AppiumDriverLocalService startServer() throws Exception
	{
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{
			
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
			return service;
	}
	
	public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	
	public static void startEmulator() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Support\\startEmulator.bat");
		Thread.sleep(10000);
	}
	
	public AndroidDriver<MobileElement> basecall() throws Exception
	{
	FileInputStream fis=new FileInputStream("C:\\Users\\SARAVANAN R\\Mobile\\E2EUSTGLOBAL\\src\\main\\java\\com\\youtube\\org\\E2EUSTGLOBAL\\config.properties");
	Properties properties=new Properties();
	properties.load(fis);
	
	String vMobileType=properties.getProperty("MobilePlatformType");
	String vOS=properties.getProperty("MobilePlatformOS");
	//String vEmulator=properties.getProperty("EmulatorName");
	
	String vEmulator=System.getProperty("eName");
	String vDriverURL=System.getProperty("eDriver");
	
	
	String vPackage=properties.getProperty("PackageName");
	String vActivity=properties.getProperty("ActivityName");
	String vTimeOut=properties.getProperty("TimeOut");
	//String vDriverURL=properties.getProperty("DriverURL");

	startEmulator();
	
	DesiredCapabilities DC=new DesiredCapabilities();
	DC.setCapability(vMobileType, vOS);
	DC.setCapability(MobileCapabilityType.DEVICE_NAME,vEmulator);
	//APP Details
	DC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,vPackage);
	DC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, vActivity);
	DC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, vTimeOut);
	myD=new AndroidDriver<>(new URL(vDriverURL),DC);
	return myD;
	
	}
}
