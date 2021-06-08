package step_Definitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import page_Objects.Add_CustomerPage;
import page_Objects.Seach_customer;
import page_Objects.loginpage;

public class Baseclass {
	WebDriver driver;
	public loginpage lp;
	public Add_CustomerPage a;
	public Seach_customer s;
	
	public static Logger logger;
	public Properties configprop;
	
	public static String randomestring(){
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	
	}
	
	
}
