#Author: your.email@your.domain.com
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: SauceLab Add Product to the cart testing

Background:
Given user has account in saucelabs
When user enters user name
And user enters password
Then login should be successful
 
  Scenario Outline: Adding products
    Given user "<user>" is on products page
    When user clicks on product "<product>"
    Then product detail page should be displayed
    And user clicks on Add to cart
    Then product "<product>" should be added to cart
    And clicks on the checkout button
    And user enters the firstname as "<fname>" and lastname as "<lname>" and zipcode as "<zipcode>"
    And clicks on the continue button
    Then Preview Page should be displayed
    And clicks on finish button
    Then order should be dispatched 
    Then closes the browser

    Examples: 
      |	user								| product  						| fname | lname  	| zipcode |
      | standard_user				| Sauce Labs Backpack | Raja 	| Murugan |	607302	|
      | standard_user				| Sauce Labs Onesie	 	| Suji 	| Rajan   |	607302	|
