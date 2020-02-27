package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Driver;
import webpage.CreatePage;
import webpage.HomePage;
import webpage.LoginPage;

public class Create implements StepDefinition {

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

	@After(order=2, value="@create-employee-positive")
	public void teardownEmployee() throws Exception {
    	this.homePage.clickNameFromList(this.firstName, this.lastName);
    	this.homePage.clickDeleteButton();
    	this.homePage.acceptDeleteAlert();
	}

	@After(order=1)
	public void teardown() throws Exception {
        this.driver.quit();
	}

    public void iniatialize() throws Throwable {
        this.driver.start();
        this.loginPage = new LoginPage(this.driver.get());
        this.homePage = new HomePage(this.driver.get());
        this.createPage = new CreatePage(this.driver.get());
    }

	@Given("^I am logged in as Luke to create new employee$")
	public void i_am_logged_in_as_luke_to_create_new_employee() throws Throwable {

        this.iniatialize();
        this.driver.navigateToHomePage();
        this.loginPage.formDisplay();
        this.loginPage.enterUsername(this.adminUsername);
        this.loginPage.enterPassword(this.adminPassword);
        this.loginPage.clickLogin();
	}

	@Given("^I am on the landing page$")
	public void i_am_on_the_landing_page() throws Throwable {
        this.homePage.employeeListDisplay();
	}

	@When("^I click the Create button$")
	public void i_click_the_create_button() throws Throwable {
        this.homePage.clickCreateButton();
	}

    @When("^I enter employee firstname \"([^\"]*)\"$")
    public void i_enter_employee_firstname(String firstName) throws Throwable {
        this.firstName = firstName;
        this.createPage.enterFirstName(firstName);
    }

    @When("^I enter employee lastname \"([^\"]*)\"$")
    public void i_enter_employee_lastname(String lastName) throws Throwable {
        this.lastName = lastName;
        this.createPage.enterLastName(lastName);
    }

    @When("^I enter employee startDate \"([^\"]*)\"$")
    public void i_enter_employee_startDate(String startDate) throws Throwable {
        this.createPage.enterStartDate(startDate);
    }

    @When("^I enter employee email \"([^\"]*)\"$")
    public void i_enter_employee_email(String email) throws Throwable {
        this.createPage.enterEmail(email);
    }

	@When("^I click on Add button$")
	public void user_submit_the_Create_form() throws Throwable {
        this.createPage.clickAddButton();
	}

    @When("^I select newly created employee name from the list \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_select_newly_created_employee_name_from_the_list(String firstName,
            String lastName) throws Throwable {
        this.homePage.doubleClickNameFromList(firstName, lastName);
    }

    @Then("^I should see correct details for newly created employee \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_should_see_correct_details_for_newly_created_employee(String firstName,
            String lastName, String startDate, String email) throws Throwable {
	    this.createPage.assertFirstName(firstName);
	    this.createPage.assertLastName(lastName);
	    this.createPage.assertStartDate(startDate);
	    this.createPage.assertEmail(email);
        this.homePage.clickBackButton();
    }

	@Then("^I fail to create new employee$")
	public void i_fail_to_create_new_employee() throws Throwable {
	    this.createPage.checkAddBtnDisable();
	    this.createPage.acceptAlert();
	}

	@When("^I click on Cancel button$")
	public void i_click_on_cancel_button() throws Throwable {
	    this.createPage.clickCancelButton();
	}

	@Then("^I should go back to home page$")
	public void i_should_go_back_to_home_page() throws Throwable {
	    this.homePage.employeeListDisplay();
	}
}
