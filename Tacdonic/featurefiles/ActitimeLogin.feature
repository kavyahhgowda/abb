Feature: Login feature
Scenario: Valid Login
Given User should enter "http://localhost/login.do" in browser
When He enters valid "admin" as username and "manager" as password
And Clicks on login button
Then Home page should be displayed