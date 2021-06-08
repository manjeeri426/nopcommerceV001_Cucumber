package step_Definitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import junit.framework.Assert;
import page_Objects.Add_CustomerPage;
import page_Objects.Seach_customer;
import page_Objects.loginpage;

public class login extends Baseclass {


	@Before
	public void setup() throws IOException
	{
           configprop=new Properties(); // instatiate properties class object
            FileInputStream configpropfile=new FileInputStream("config.properties");  // getting configproperties filr in fileinputstream
            configprop.load(configpropfile); // loading configproperties file using property class object
		
            logger=logger.getLogger("nopcommerce");    // Added logger
		PropertyConfigurator.configure("log4j.properties"); // Added logger
		String browser=configprop.getProperty("browser");  //getting browser from configproperty file
		
		if(browser.equals("chrome"))    // based on browser name we are launching browser
		{		
		System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath"));
		driver=new ChromeDriver();
	     }
		else
		{
			System.setProperty("webdriver.chrome.driver",configprop.getProperty("firepath"));
			driver=new FirefoxDriver();
		}
		
		logger.info("launching browser");
		
	}	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
		
		}   

	@When("User opens URL {string}")
	public void user_opens_url(String string) {
	    // Write code here that turns the phrase above into concrete actions
	 logger.info("Opening URL");
		driver.get(string);
	   driver.manage().window().maximize();
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	  
		 lp=new loginpage(driver);
		
		 logger.info("providing usernam and password");
		lp.setusername(string);
		lp.setpassword(string2);

		}

	@When("Click on Login")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
	lp.login();   
	
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   
		if(driver.getPageSource().contains("Login was unsuccessfull"))
		{
			logger.info("login unsuccessfull");
			driver.quit();
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("login succesfull");
		String title=driver.getTitle();
		Assert.assertEquals(title, string);
		}
	}

	@When("user click on Log Out link")
	public void user_click_on_log_out_link() {
	    // Write code here that turns the phrase above into concrete actions
	  
		logger.info("clicking on logout");
		lp.logout();
	}

	@Then("Close browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
	
		driver.quit();
	}
	
	// Add new customer
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
	    // Write code here that turns the phrase above into concrete actions

		a=new Add_CustomerPage(driver);
		
		System.out.println(a.getPageTitle());
		Assert.assertEquals("Dashboard / nopCommerce administration",a.getPageTitle());;
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	 a.clickOnCustomersMenu();
		Thread.sleep(3000);
	}

	@When("click on Customers Menu item")
	public void click_on_Customers_Menu_item() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   a.clickOnCustomersMenuItem();
		Thread.sleep(3000);
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() {
	    // Write code here that turns the phrase above into concrete actions
	   a.click_on_add_new();
	}

	@Then("user can view Add New Customer Page")
	public void user_can_view_Add_New_Customer_Page() {
	    // Write code here that turns the phrase above into concrete actions
	    boolean text=driver.findElement(By.tagName("body")).getText().contains("Add a new customer");
	    Assert.assertEquals(true,text);
	    
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		logger.info("providing customer details");
		String email=randomestring()+"@yahoo.com";
	  a.send_email(email);
	  a.send_password("mn@123");
	  a.send_firstname("misha");
	  a.send_lastname("pande");
	  a.click_gender("female");
	  a.send_dob("5/05/1993");
	  a.send_company("karton");
	  a.click_taxexcempt();
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,550)");
	  Thread.sleep(3000);
	  a.select_newsletter("Test store 2");
	 // Thread.sleep(2000);
	  //a.send_custrole("Guests");
	  //Thread.sleep(2000);
	  a.send_vendor("Vendor 1");
	  
	  //a.click_active();
	  a.send_admincontent("good");
	  
	  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 logger.info("saving data");
		a.save_button();
		  
	}

	@Then("User can view confirmation messege {string}")
	public void user_can_view_confirmation_messege(String string) {
	    // Write code here that turns the phrase above into concrete actions
		
		logger.info("validating customer messege");
	  boolean status=driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully.");
		Assert.assertEquals(true,status);
	}
	
	// search customer by email
	
	@When("Click on search text")
	public void click_on_search_text() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		s=new Seach_customer(driver);
		s.searchtext();
		Thread.sleep(3000);
	}
	
	@When("enter email")
	public void enter_email() throws InterruptedException {
		
		logger.info("searching by email");
		s=new Seach_customer(driver);
		s.searchby_email("admin@yourStore.com");
		Thread.sleep(3000);
		s.search_button();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,550)");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	
	  }
	
	@Then("User should found email in search table")
	public void user_should_found_email_in_search_table() throws InterruptedException {
		s=new Seach_customer(driver);
	    boolean status=s.is_email_found_in_table("victoria_victoria@nopCommerce.com");
	    
	    Assert.assertEquals(true, status);
	    Thread.sleep(3000);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    
	}

	
	// search customer by name
	
	@When("enter firstname and lastname")
	public void enter_firstname_and_lastname() throws InterruptedException {
		
		logger.info("searching by name");
		s=new Seach_customer(driver);
		s.searchby_firstname("John");
		Thread.sleep(3000);
		s.searchby_lastname("Smith");
		Thread.sleep(3000);
		s.search_button();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,550)");
	}

	@Then("User should found name in search table")
	public void user_should_found_name_in_search_table() {
	   
		s=new Seach_customer(driver);
		boolean status=s.is_name_found_in_table("misha","pande");
		Assert.assertEquals(true, status);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}


	
	


	


}

	

