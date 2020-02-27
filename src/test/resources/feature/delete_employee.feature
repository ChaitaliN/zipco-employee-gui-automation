@delete-employee
Feature: Delete Employee

    Delete employee for Cafe Townsend app

    @delete-employee-home-page
	Scenario Outline: Delete employee from home page with positive test case

		Given I am logged in as Luke to delete employee
        And I check employee with name "<firstName>", "<lastName>" exists
		When I select name "<firstName>", "<lastName>" from employee list
		When I click delete on home page
		And I accept delete alert
		Then I should not see employee with name "<firstName>", "<lastName>" in the list

		Examples:
		|firstName    |lastName    |
		|testFirstName|testLastName|

    @delete-employee-edit-page
	Scenario Outline: Delete employee from edit page with positive test case

		Given I am logged in as Luke to delete employee
        And I check employee with name "<firstName>", "<lastName>" exists
		When I select name "<firstName>", "<lastName>" from employee list
        When I click on edit employee
		When I click delete on edit page
		And I accept delete alert
		Then I should not see employee with name "<firstName>", "<lastName>" in the list

		Examples:
		|firstName    |lastName    |
		|testFirstName|testLastName|
