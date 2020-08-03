import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTC1 
{
	
	
	@Test
	public void GOOGLETC001()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SARAVANAN R\\Desktop\\UST Global Appium\\Selenium\\chromedriver.exe");
		WebDriver myD=new ChromeDriver();
		myD.get("https://www.google.co.in");
		System.out.println(myD.getTitle());
		myD.quit();

	}

}
