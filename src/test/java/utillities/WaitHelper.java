package utillities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver driver;
	
	public WaitHelper(WebDriver driver)
	{
		driver=this.driver;
	}
	
	public void explicitwait(WebElement element,int time)
	{
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
	}
	
}
