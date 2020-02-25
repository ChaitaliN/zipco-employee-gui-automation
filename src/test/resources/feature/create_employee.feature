@create-employee
Feature: Create Employee

    Create new employee for Cafe Townsend app

    @create-employee-positive
	Scenario Outline: Create employee with positive test

		Given I am logged in as Luke
		And I am on the landing page
		When I click the Create button
		And I enter employee firstname "<firstName>"
		And I enter employee lastname "<lastName>"
		And I enter employee startDate "<startDate>"
		And I enter employee email "<email>"
		And I click on Add button
		When I select newly created employee name from the list "<firstName>", "<lastName>"
		Then I should see correct details for newly created employee "<firstName>", "<lastName>", "<startDate>", "<email>"

		Examples:
		|firstName       |lastName              |startDate     |email         |
		|test            |createNewPastDate     |2010-09-15    |test@test.com |
		# |test            |createNewFutureDate   |2025-09-15    |test@test.com |
