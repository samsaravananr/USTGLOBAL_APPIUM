import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

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
import java.io.FileOutputStream;
import java.io.IOException;

public class HyBridAPPAGEREADWRITE 
{
	public static String vFlag;
	public static AndroidDriver<AndroidElement> myD;
	public static String vProduct="Converse All Star";
	public static int xlRows,xlCols;
	public static String xData[][];
	public static String vName;
	public static double vSum;
	public static DateFormat dateFormat;
	public static File vFile;
	

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
		myD.findElementById("com.androidsample.generalstore:id/nameField").sendKeys(vName);
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
		
		vSum=Double.parseDouble(vPrice1)+Double.parseDouble(vPrice2);
		
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
	
	
	
	public static void xlRead(String sPath) throws Exception
	{
		File myFile=new File(sPath);
		FileInputStream myStream=new FileInputStream(myFile);
		HSSFWorkbook myworkbook=new HSSFWorkbook(myStream);
		HSSFSheet mySheet=myworkbook.getSheetAt(2);
		xlRows=mySheet.getLastRowNum()+1;
		xlCols=mySheet.getRow(0).getLastCellNum();
		System.out.println("Row Number is "+xlRows);
		System.out.println("Col Number is "+xlCols);
		xData=new String[xlRows][xlCols];
		for(int i=0;i<xlRows;i++)
		{
			HSSFRow row=mySheet.getRow(i);
			for(short j=0;j<xlCols;j++)
			{
				HSSFCell cell=row.getCell(j);
				String value=cellToString(cell);
				xData[i][j]=value;
				System.out.print("-"+xData[i][j]);
			}
			System.out.println();
		}
	}
		@SuppressWarnings("deprecation")
		public static String cellToString(HSSFCell cell)
		{
			int type=cell.getCellType();
			Object result;
			switch(type)
			{
			case HSSFCell.CELL_TYPE_NUMERIC:
			result=cell.getNumericCellValue();
			break;
			case HSSFCell.CELL_TYPE_STRING:
			result=cell.getStringCellValue();
			break;
			case HSSFCell.CELL_TYPE_FORMULA:
			throw new RuntimeException("We cannot evaluate formula");
			case HSSFCell.CELL_TYPE_BLANK:
			result="-";
			case HSSFCell.CELL_TYPE_BOOLEAN:
			result=cell.getBooleanCellValue();
			case HSSFCell.CELL_TYPE_ERROR:
			result="This cell has some error";
			default:
			throw new RuntimeException("We do not support this cell type");
			}
			return result.toString();
			
		}
		
		
		public static void xlwrite(String xlpath1,String[][] xData) throws Exception
		{
			System.out.println("Inside XL Write");
			File myFile1=new File(xlpath1);
			FileOutputStream fout=new FileOutputStream(myFile1);
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet mySheet1=wb.createSheet("TestResults");
			for(int i=0;i<xlRows;i++)
			{
				HSSFRow row1=mySheet1.createRow(i);
				for(short j=0;j<xlCols;j++)
				{
					HSSFCell cell1=row1.createCell(j);
					cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell1.setCellValue(xData[i][j]);
				}
			}
			wb.write(fout);
			fout.flush();
			fout.close();
		}
	
		public static void takeScreenShot() 
		{
		 // Set folder name to store screenshots.
		  String destDir = "screenshots";
		  // Capture screenshot.
		  File scrFile = ((TakesScreenshot) myD).getScreenshotAs(OutputType.FILE);
		  // Set date format to set It as screenshot file name.
		  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		  // Create folder under project with name "screenshots" provided to destDir.
		  new File(destDir).mkdirs();
		  // Set file name using current date time.
		  String destFile = dateFormat.format(new Date()) + ".png";
		  
		  

		  try {
		   // Copy paste file at destination folder location
		   Files.copy(scrFile, new File(destDir + "/" + destFile));
		   vFile=new File("C:\\Users\\SARAVANAN R\\Mobile\\USTMobileDemo\\screenshots\\"+destFile);
		   System.out.println(vFile);
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
	
}
