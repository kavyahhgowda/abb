Feature: Login Feature
Scenario Outline: Login to actitime with multipple data
Given User should enter the url as "http://localhost/login.do" in browser
When He enters "<username>" and "<password>" in the textbox
And He clicks on login button
Then Homepage must be displayed

Examples: 
|username|password|
|admin|manager|
|RCB|ESCN|
|Modi|Rahul|