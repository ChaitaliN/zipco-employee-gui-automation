package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import driver.Driver;
import webpage.CreatePage;
import webpage.HomePage;
import webpage.LoginPage;

public class Update implements StepDefinition {

    String adminUsername = "Luke";
    String adminPassword = "Skywalker";
    String firstName;
    String lastName;

    public Driver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public CreatePage createPage;

    @Before(order=1)
    public void setup() {
        this.driver = new Driver();
    }

    public void initialize() throws Throwable {
        this.driver.start();
        this.loginPage = new LoginPage(this.driver.get());
        this.homePage = new HomePage(this.driver.get());
        this.createPage = new CreatePage(this.driver.get());
    }

	@After(order=2, value="@update-employee-positive")
	public void teardownEmployee() throws Exception {
    	this.homePage.clickNameFromList(this.firstName, this.lastName);
    	this.homePage.clickDeleteButton();
    	this.homePage.acceptDeleteAlert();
	}

	@After(order=1)
	public void teardown() throws Exception {
        this.driver.quit();
	}

    @Given("^I am logged in as Luke to update employee$")
    public void i_am_logged_in_as_Luke_to_update_employee() throws Throwable {

        this.initialize();
        this.driver.navigateToHomePage();
        this.loginPage.formDisplay();
        this.loginPage.enterUsername(this.adminUsername);
        this.loginPage.enterPassword(this.adminPassword);
        this.loginPage.clickLogin();
    }

    @Given("^I check if employee with name \"([^\"]*)\", \"([^\"]*)\" exists$")
    public void i_check_if_employee_with_name_exists(String existingFirstName,
            String existingLastName) throws Throwable {
        this.homePage.clickCreateButton();
        this.createPage.enterFirstName(existingFirstName);
        this.createPage.enterLastName(existingLastName);
        this.createPage.enterStartDate("2020-03-03");
        this.createPage.enterEmail("test@test.com");
        this.createPage.clickAddButton();
    }

    @When("^I select employee \"([^\"]*)\", \"([^\"]*)\" from the list$")
    public void i_select_employee_from_the_list(String existingFirstName,
            String existingLastName) throws Throwable {
        this.homePage.selectNameFromList(existingFirstName, existingLastName);
    }

    @When("^I click the edit button$")
    public void i_click_the_edit_button() throws Throwable {
        this.homePage.clickEditButton();
    }

    @When("^I change employee firstname to \"([^\"]*)\"$")
    public void i_change_employee_firstname_to(String firstName) throws Throwable {
        this.firstName = firstName;
        this.createPage.enterFirstName(firstName);
    }

    @When("^I change employee lastname to \"([^\"]*)\"$")
    public void i_change_employee_lastname_to(String lastName) throws Throwable {
        this.lastName = lastName;
        this.createPage.enterLastName(lastName);
    }

    @When("^I change employee start date to \"([^\"]*)\"$")
    public void i_change_employee_start_date_to(String startDate) throws Throwable {
        this.createPage.enterStartDate(startDate);
    }

    @When("^I change employee email to \"([^\"]*)\"$")
    public void i_change_employee_email_to(String email) throws Throwable {
        this.createPage.enterEmail(email);
    }

    @When("^I update employee details$")
    public void i_update_employee_details() throws Throwable {
	    this.createPage.clickUpdateButton();
	    this.createPage.acceptAlert();
    }

    @When("^I select employee \"([^\"]*)\", \"([^\"]*)\" from list$")
    public void i_select_employee_from_list(String firstName, String lastName) throws Throwable {
	    this.homePage.doubleClickNameFromList(firstName, lastName);
    }

    @Then("^I should see updated details of employee \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_should_see_updated_details_of_employee(String firstName, String lastName,
            String startDate, String email) throws Throwable {
		this.createPage.assertFirstName(firstName);
	    this.createPage.assertLastName(lastName);
	    this.createPage.assertStartDate(startDate);
	    this.createPage.assertEmail(email);
	    this.createPage.clickBackButton();
    }

    @When("^I should be unable to update employee$")
    public void i_should_be_unable_to_update_employee() throws Throwable {
	    this.createPage.clickBackButton();
	    this.homePage.employeeListDisplay();
    }
}
