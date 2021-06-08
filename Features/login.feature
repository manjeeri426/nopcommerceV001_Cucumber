Feature: Login

@Sanity
Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When  User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And   User enters email as "admin@yourstore.com" and password as "admin"
    And   Click on Login
    Then  Page Title should be "Dashboard / nopCommerce administration"
    When  user click on Log Out link
    Then  Page Title should be "Your store. Login"
    And   Close browser
    
@Regression   
Scenario Outline:  Login data driven
       Given User launch chrome browser
    When  User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And   User enters email as "<email>" and password as "<password>"
    And   Click on Login
    Then  Page Title should be "Dashboard / nopCommerce administration"
    When  user click on Log Out link
    Then  Page Title should be "Your store. Login"
    And   Close browser
    
    
      Examples:
               |email        | password |
               |admin@yourstore.com|admin|
               |admin@yourstore.com|admin123|