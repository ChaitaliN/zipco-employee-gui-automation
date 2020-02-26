@delete-employee
Feature: Delete Employee

    Delete employee for Cafe Townsend app

    @delete-employee-home-page
	Scenario Outline: Delete employee from home page with positive test case

		Given I am logged in as Luke to delete employee
		And I select name "<firstName>", "<lastName>" from employee list
		When I click Delete on home page
		And I accept delete alert
		Then I should not see employee with name "<firstName>", "<lastName>" in the list

		Examples:
		|firstName    |lastName    |
		|testFirstName|testLastName|
