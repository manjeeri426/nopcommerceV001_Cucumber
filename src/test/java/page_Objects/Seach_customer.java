package page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.List;

import utillities.WaitHelper;

public class Seach_customer {

	
	WebDriver ldriver;
	public WaitHelper p; 
	
	public Seach_customer(WebDriver rdriver)
	{
		
		ldriver=rdriver;
		
		PageFactory.initElements(ldriver,this);
		
		p=new WaitHelper(ldriver);
		
	}
	
	By searchtext=By.xpath("//div[@class='search-text']");
	
	By searchbyemail=By.xpath("//input[@id='SearchEmail']");
	By searchbyfirstname=By.xpath("//input[@id='SearchFirstName']");
	By searchbylastname=By.xpath("//input[@id='SearchLastName']");
	By searchbutton=By.xpath("//button[normalize-space()='Search']");
	
	By tablerows=By.xpath("//tbody/tr");
	By tablecolumn=By.xpath("//tbody/tr/td");
	
	
	
	public void searchtext()
	{
	ldriver.findElement(searchtext).click();
	}
	
	public void searchby_email(String email)
	{
		new WebDriverWait(ldriver, 7).until(ExpectedConditions.visibilityOf(ldriver.findElement(searchbyemail))).sendKeys(email);		
		
	}
	public void searchby_firstname(String firstname)
	{
		new WebDriverWait(ldriver, 7).until(ExpectedConditions.visibilityOf(ldriver.findElement(searchbyfirstname))).sendKeys(firstname);	
		//ldriver.findElement(searchbyfirstname).sendKeys(firstname);
		
	}
	public void searchby_lastname(String lastname)
	{
		new WebDriverWait(ldriver, 7).until(ExpectedConditions.visibilityOf(ldriver.findElement(searchbylastname))).sendKeys(lastname);	
		//ldriver.findElement(searchbylastname).sendKeys(lastname);	
	}

	public void search_button()
	{
	new WebDriverWait(ldriver, 5).until(ExpectedConditions.elementToBeClickable(ldriver.findElement(searchbutton))).click();	
	
	}
	
	public boolean is_email_found_in_table(String email)
	{
	
	boolean flag=false;
		
	 java.util.List<WebElement> rows=ldriver.findElements(tablerows);
	 
	 rows.size();
	 
	 java.util.List<WebElement> column=ldriver.findElements(tablecolumn);
	 
	 
	 for(int i=1;i<=rows.size();i++)
	 {
		String actual_email=ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
		 if(actual_email.equals(email))
		 {
			 flag=true;
			 break;
		 }	 
		
	}
	 
	    return flag;
	}
	
	
	public boolean is_name_found_in_table(String firstname,String lastname)
	{
	
	boolean flag=false;
		
	 java.util.List<WebElement> rows=ldriver.findElements(tablerows);
	 
	 rows.size();
	 
	 java.util.List<WebElement> column=ldriver.findElements(tablecolumn);
	 
	 
	 
	 for(int i=1;i<=rows.size();i++)
	 {
		 
		 String actual_name=ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
		String names[]=actual_name.split(" ");
		 if(names[0].equals(firstname) && names[1].equals(lastname))
		 {
			 flag=true;
			 break;
		 }	 
		
	}
	 
	    return flag;
	}
	
	
	 
	
	
	 
	}
	


	
	
	

