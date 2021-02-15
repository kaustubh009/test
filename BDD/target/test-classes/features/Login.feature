Feature: Application Login

Scenario: Check if user is able to login
Given User is on Home page
When User logs in application with credentials username"test" and password "test@123"
Then User should land on welcome page
And Card details are displayed "true"


Scenario: Check if user is able to login
Given User is on Home page
When User logs in application with credentials username"best" and password "best@123"
Then User should land on welcome page
And Card details are displayed "false"