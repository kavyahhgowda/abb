@CustomerModule
Feature: Customer Module
Scenario Outline: Create customer
Given User should be present in home page
When He Clicks on task tab
Then The title should be "actiTIME - Task List"
When he clicks on add new button
And he clicks on new customer button
Then create new customer popup should be displayed
When he enters the customer name as "<cusName>"
And he enters the description as "<cusDesc>"
And he selects our company in the dropdown
When he clicks on create customer button
Then Customer should be created as "<cusName>"

Examples:
|cusName|cusDesc|
|nac|engg|
|mac|dr|
|sick|CA|

