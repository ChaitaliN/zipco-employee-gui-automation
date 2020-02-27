@create-employee
Feature: Create Employee

    Create new employee for Cafe Townsend app

    @create-employee-positive
	Scenario Outline: Create employee with positive test case

		Given I am logged in as Luke to create new employee
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
		|firstName     |lastName     |startDate |email        |
		|testFirstName1|testLastName1|2020-03-03|test@test.com|
		|testFirstName2|testLastName2|2020-04-04|test@test.com|

    @create-employee-negative
	Scenario Outline: Create employee with negative test case

		Given I am logged in as Luke to create new employee
		And I am on the landing page
		When I click the Create button
		And I enter employee firstname "<firstName>"
		And I enter employee lastname "<lastName>"
		And I enter employee startDate "<startDate>"
		And I enter employee email "<email>"
		And I click on Add button
		Then I fail to create new employee

		Examples:
		|firstName       |lastName              |startDate     |email         |
		|testFirstName   |testLastName          |2020-29       |test@test.com |
		|                |testLastName          |2020-03-03    |test@test.com |
		|testFirstName   |                      |2020-04-04    |test@test.com |

    @create-employee-cancel
	Scenario: Cancel employee creation

		Given I am logged in as Luke to create new employee
		And I am on the landing page
		When I click the Create button
		And I click on Cancel button
		Then I should go back to home page
