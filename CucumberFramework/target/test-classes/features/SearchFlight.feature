Feature: Search Flight for the Customer

@test
Scenario: User navigates to new window for Flight Booking

Given User is on GreenCart Landing page
When user clicks on Flight Booking link
Then user navigates to new window for flight booking
And user selects country "<India>" from the dropdwon.


Scenario Outline: User searches for a flight with given input and gets the result

  Given User is on GreenCart Landing page
  When user clicks on Flight Booking link
  Then user selects RoundTrip Radio
  Then user enters all the details with From "<From>", To "<To>"
  And user clicks on Family and Friends checkbox
  And user clicks on Search button

  Examples:
    | From 			 | To         
    | Pune (PNQ) | Goa (GOI)  


