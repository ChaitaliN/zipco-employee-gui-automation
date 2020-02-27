@update-employee
Feature: Update Employee

    Update existing employee for Cafe Townsend app

    @update-employee-positive
	Scenario Outline: Update employee with positive test case

 		Given I am logged in as Luke to update employee
		And I check if employee with name "<existingFirstName>", "<existingLastName>" exists
		When I select employee "<existingFirstName>", "<existingLastName>" from the list
		And I click the edit button
		And I change employee firstname to "<firstName>"
		And I change employee lastname to "<lastName>"
		And I change employee start date to "<startDate>"
		And I change employee email to "<email>"
		And I update employee details
		When I select employee "<firstName>", "<lastName>" from list
        Then I should see updated details of employee "<firstName>", "<lastName>", "<startDate>", "<email>"

		Examples:
        |existingFirstName |existingLastName |firstName      |lastName      |startDate  |email              |
		|testOldFirstName1 |testOldLastName1 |testFirstName1 |testLastName1 |2020-09-09 |testupdate@test.com|
