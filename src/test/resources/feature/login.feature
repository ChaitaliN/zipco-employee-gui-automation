@login-employee
Feature: Login Employee

    @login-positive
	Scenario Outline: Login employee with positive test case

		Given I am on login page with title "<title>"
		And I see login form displayed
		When I enter username "<username>"
		And I enter password "<password>"
		And I click on login button
		Then I should see "<username>" in greeting message

		Examples:
        |title                        |username |password  |
        |CafeTownsend-AngularJS-Rails |Luke     |Skywalker |

    @login-negative
	Scenario Outline: Login employee with negative test case

		Given I am on login page with title "<title>"
		And I see login form displayed
		When I enter username "<username>"
		And I enter password "<password>"
		And I click on login button
		Then I should see "<message>"

		Examples:
        |title                        |username |password   |message				      |
        |CafeTownsend-AngularJS-Rails |Luke     |Sky        |Invalid username or password!|
