package page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utillities.WaitHelper;

public class Add_CustomerPage {

	WebDriver ldriver;
	public WaitHelper p;
	
	public Add_CustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
		p=new WaitHelper(ldriver);
	}
	
	By customers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By customer_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By add_new_link=By.xpath("//a[normalize-space()='Add new']");
	By  email=By.xpath("//input[@id='Email'] ");
	By password=By.xpath("	//input[@id='Password']");
	By firstname=By.xpath("//input[@id='FirstName']");
	By lastname=By.xpath("//input[@id='LastName']");
	By gender_female=By.xpath("//input[@id='Gender_Female']");
	By gender_male=By.xpath("//input[@id='Gender_male']");
	By dob=By.xpath("//input[@id='DateOfBirth']");
	By company=By.xpath("//input[@id='Company']");
	By istaxexcempt=By.xpath("//input[@id='IsTaxExempt']");
	By newsletter=By.xpath("//select[@id='SelectedNewsletterSubscriptionStoreIds']");
	By newsitem1=By.xpath("//li[normalize-space()='Test store 2']");
	By newsitem2=By.xpath("//li[@id='65749df4-1332-4db5-b093-9156f6092c11']");
	By custrole=By.xpath("//select[@id='SelectedCustomerRoleIds']");
	By adminastrators=By.xpath("//li[normalize-space()='Administrators']");
	By forum=By.xpath("//li[normalize-space()='Forum Moderators']");
	By guest=By.xpath("//li[normalize-space()='Guests']");
	By Registered=By.xpath("//li[@id='8064380c-4704-4110-882e-15a36848449a']");
	By vendors=By.xpath("/li[contains(text(),'Vendors')]");
	By vendorno=By.xpath("//select[@id='VendorId']");
	By clickactive=By.xpath("//input[@id='Active']");
	By admincontent=By.xpath("//textarea[@id='AdminComment']");
	By savebutton=By.xpath("//button[@name='save']");


	//Actions Methods
	
		public String getPageTitle()
		{
			return ldriver.getTitle();
		}
		
		public void clickOnCustomersMenu() {
			ldriver.findElement(customers_menu).click();
		}
		
		public void clickOnCustomersMenuItem()
		{
		ldriver.findElement(customer_menuitem).click();
		}
		
		public void click_on_add_new()
		{
			ldriver.findElement(add_new_link).click();
		}
        
		public void send_email(String Email)
		{
			ldriver.findElement(email).sendKeys(Email);
		}
		public void send_password(String pwd)
		{
			ldriver.findElement(password).sendKeys(pwd);
		}
		
		public void send_firstname(String Firstname)
		{
			ldriver.findElement(firstname).sendKeys(Firstname);
		}
		public void send_lastname(String Lastname)
		{
			ldriver.findElement(lastname).sendKeys(Lastname);
		}
		public void click_gender(String gender)
		{
			if(gender.equals("female"))
			{
			ldriver.findElement(gender_female).click();
	     	}
			else
			{
			ldriver.findElement(gender_male).click();	
			}
		}
		public void send_dob(String DOB)
		{
			ldriver.findElement(dob).sendKeys(DOB);
		}
		public void send_company(String Company)
		{
			ldriver.findElement(company).sendKeys(Company);
		}
		
		public void click_taxexcempt()
		{
			ldriver.findElement(istaxexcempt).click();
		}
		public void select_newsletter(String item)
		{
			WebElement listitem;
			if(item.equals("Test store 2"))
			{
			listitem=ldriver.findElement(newsitem1);
			}
			else
			{
				listitem=ldriver.findElement(newsitem2);
			}
			
			JavascriptExecutor js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click();", listitem);
			
		}
		
		public void send_custrole(String role)
		{
			WebElement listitem;
		 if(role.equals("Administrators"))
		 {
		listitem=ldriver.findElement(adminastrators);
		 }
		 else if(role.equals("Forum Moderators"))
		 {
			listitem= ldriver.findElement(forum);
		 }
		 else if(role.equals("Guests"))
		 {
			 listitem=ldriver.findElement(guest);
		 }
		 else if(role.equals("Registered"))
		 {
			 listitem=ldriver.findElement(Registered);
		 }
		 else 
		 {
			 listitem=ldriver.findElement(vendors);
		 }
		
		 JavascriptExecutor js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click();", listitem);
		 
		 }
		
		public void send_vendor(String Vendor)
		{
			Select s=new Select(ldriver.findElement(vendorno));
			s.selectByVisibleText(Vendor);
		     
		}
		
		public void click_active()
		{
		ldriver.findElement(clickactive).click();
		}
		public void send_admincontent(String content)
		{
		ldriver.findElement(admincontent).sendKeys(content);
		}
		
		public void save_button()
		{
			/*WebElement savebutton1=ldriver.findElement(savebutton);
			p.explicitwait(savebutton1,6); */
			
			ldriver.findElement(savebutton).click();
			
		
		}
		
		
		
		
	
 

}
