Feature: Sauce Labs Login validation

Background: user opens saucelabs

Scenario: Successful login using valid user name and password
Given user has account in saucelabs
When user enters user name
And user enters password
Then login should be successful

Scenario: login using invalid user name and password
Given user has account in saucelabs
When user enters invalid user name
And user enters invalid password
Then login should not be successful