Feature: This feature runs for login page

@validlogin @logintest
Scenario: User should login successfully with valid data

Given User is in login page
When User enters email id "prashanthi.skvl@gmail.com"
And User enters password "Test@123"
And User clicks signin button
Then User should see All projects page

@invalidlogin @logintest
Scenario Outline: User should not login with Invalid data

Given User is in login page
When User enters email id "<EmailId>"
And User enters password "<Password>"
And User clicks signin button
Then User should not see All projects page

Examples:

|EmailId|Password|
|test678@gmail.com|Test|
|test8765@gmail.com|Test123|
