Feature: User Registration
@test
Scenario: Successfull Regitartion with valid input

Given User is on Registration Page
When User enters all the valid inputs
|Pooja|
|Batale|
|Test@test.com|
|8756435612|
|FeMale|
|India|
|Pass@123|
|PAss@123|
Then User clicks on Submit Button
Then User registration successful



 

