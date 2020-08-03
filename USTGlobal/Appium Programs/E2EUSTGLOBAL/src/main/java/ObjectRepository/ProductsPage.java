package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage 
{

	
	public ProductsPage(AndroidDriver<MobileElement> myD)
	{
		PageFactory.initElements(new AppiumFieldDecorator(myD), this);
	}
	
	@AndroidFindBy (id = "com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> addToCart;
	
	@AndroidFindBy (id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement addToCartButton;
	
	public WebElement submitCart()
	{
		return addToCartButton;
	}
	
	
}
