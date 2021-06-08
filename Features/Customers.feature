Feature: Customers 

Background: Below are the common steps for every scenario 
	Given User launch chrome browser 
	When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
	And User enters email as "admin@yourstore.com" and password as "admin" 
	And Click on Login 
	Then User can view Dashboard 
	 
@Sanity	
Scenario: Add new Customer 
	When User click on customers menu 
	And click on Customers Menu item 
	And click on Add new button 
	Then user can view Add New Customer Page 
	When user enter customer info 
	And click on Save button 
	Then User can view confirmation messege "The new customer has been added successfully." 
	When  user click on Log Out link
    Then  Page Title should be "Your store. Login"
    And Close browser 

@Regression	
Scenario: search customer by email_id 
	When User click on customers menu 
	And click on Customers Menu item 
	And  Click on search button
	And enter email 
	When click on search button 
	Then User should found email in search table 
	And Close browser 
	 
@Regression		
Scenario: search customer by firstname and lastname 
	When User click on customers menu 
	And click on Customers Menu item 
	And  Click on search text
	And enter firstname and lastname 
	When click on search button 
	Then User should found name in search table 
	And Close browser 
	
