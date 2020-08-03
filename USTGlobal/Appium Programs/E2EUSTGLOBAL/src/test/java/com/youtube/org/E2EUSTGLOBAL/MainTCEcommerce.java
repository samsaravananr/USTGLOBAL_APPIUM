package com.youtube.org.E2EUSTGLOBAL;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.LoginPage;
import ObjectRepository.PaymentsPage;
import ObjectRepository.ProductsPage;
import Support.ScrollFun;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MainTCEcommerce extends BaseEcommerce
{

	@Test
	public void TC001() throws Exception
	{
		service=startServer();
		AndroidDriver<MobileElement> myD=basecall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage LP=new LoginPage(myD);
		ProductsPage PP=new ProductsPage(myD);
		PaymentsPage PAY=new PaymentsPage(myD);
		ScrollFun scroll=new ScrollFun(myD);
		
		LP.countryList.click();
		Thread.sleep(3000);
		scroll.ScrollText("Australia");
		
		LP.countryData.click();
		LP.userName.sendKeys("USTGLobal");
				
		myD.hideKeyboard();
		
		LP.female.click();
		Thread.sleep(3000);
		LP.male.click();
		
		LP.letsShop.click();
		
		ScrollFun.ScrollText("Converse All Star");
		
		//myD.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\").instance(0))"));
		
		PP.addToCart.get(0).click();
		PP.addToCart.get(1).click();
		
		PP.submitCart().click();
		
		Thread.sleep(4000);
		
		
		String vPrice1=PAY.productPrice.get(0).getText();
		String vPrice2=PAY.productPrice.get(1).getText();
		String vTotal=PAY.totalAmount.getText();
			
		System.out.println("Price 1" + vPrice1 + "   Price 2 "+vPrice2+ "    Total is "+vTotal);
		
		myD.closeApp();
		Thread.sleep(5000);
		service.stop();


		
	}
	
	
	@BeforeTest
	public void killprocess() throws Exception
	{
		System.out.println("All TASK KILLED");
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
}
