Feature: Check the data table

@test
Scenario: Verify the sorting of the table

Given: User is on landing page

When user scroll down the page
Then datatable is displaying
Then user checks if Name coulmn is sorted ascending by default
Then user clicks on Name coulmn and check if Name coulmn is sorted descending.


