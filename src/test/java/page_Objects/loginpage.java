package page_Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver ldriver;
	public loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(id="Email")
	public WebElement usernamefield;
	

	@FindBy(id="Password")
	public WebElement passwordfield;
	

	@FindBy(xpath="//button[normalize-space()='Log in']")
	public WebElement loginbutton;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	public WebElement logoutbutton;
	
	
	public void setusername(String username)
	{
		usernamefield.clear();
		usernamefield.sendKeys(username);
	}
	
	public void setpassword(String password)
	{
		passwordfield.clear();
		passwordfield.sendKeys(password);
	}
	
	public void login()
	{
		loginbutton.click();
	}
	public void logout()
	{
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click()",logoutbutton);
		
	}
}
