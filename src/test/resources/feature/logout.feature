@logout-employee
Feature: Logout Employee

    Logout employee from Cafe Townsend app

    @logout
	Scenario: Employee logout

		Given I am logged in as Luke to logout back
		When I click logout button
		Then I should be back on login page
