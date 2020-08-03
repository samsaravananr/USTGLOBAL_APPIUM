package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class YOUTUBEHOME 
{

	public YOUTUBEHOME(AndroidDriver<MobileElement> myD)
	{
		PageFactory.initElements(new AppiumFieldDecorator(myD), this);
	}
	
	
	@AndroidFindBy (id = "com.google.android.youtube:id/menu_item_1")
	public WebElement searchButton;
	
	@AndroidFindBy (id = "com.google.android.youtube:id/search_edit_text")
	public WebElement searchTextField;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='ust global trivandrum']")
	public WebElement searchData;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@index='0']")
	public WebElement ustVideo;
	
}
