Feature: User Registration
@test
Scenario: Successfull Regitartion with valid input

Given User is on Registration Page
When User enters all the valid inputs
|Fname|Pooja|
|Lname|Batale|
|Email|Test@test.com|
|Phone|8756435612|
|Gender|FeMale|
|Country|India|
|Pass1|Pass@123|
|Pass2|PAss@123|
Then User clicks on Submit Button
Then User registration successful



 

