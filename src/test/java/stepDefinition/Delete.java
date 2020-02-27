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

public class Delete implements StepDefinition {

    String adminUsername = "Luke";
    String adminPassword = "Skywalker";

    public Driver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public CreatePage createPage;

    @Before(order=1)
    public void setup() {
        this.driver = new Driver();
    }

	@After(order=1)
	public void teardown() throws Exception {
        this.driver.quit();
	}

    public void initialize() throws Throwable {
        this.driver.start();
        this.loginPage = new LoginPage(this.driver.get());
        this.homePage = new HomePage(this.driver.get());
        this.createPage = new CreatePage(this.driver.get());
    }

	@Given("^I am logged in as Luke to delete employee$")
	public void i_am_logged_in_as_luke_to_delete_employee() throws Throwable {

        this.initialize();
        this.driver.navigateToHomePage();
        this.loginPage.formDisplay();
        this.loginPage.enterUsername(this.adminUsername);
        this.loginPage.enterPassword(this.adminPassword);
        this.loginPage.clickLogin();
	}

    @Given("^I check employee with name \"(.*?)\", \"(.*?)\" exists$")
    public void employee_with_name_exists(String firstName, String lastName) throws Throwable {
        this.homePage.clickCreateButton();
        this.createPage.enterFirstName(firstName);
        this.createPage.enterLastName(lastName);
        this.createPage.enterStartDate("2020-03-03");
        this.createPage.enterEmail("test@test.com");
        this.createPage.clickAddButton();
    }

    @Given("^I select name \"([^\"]*)\", \"([^\"]*)\" from employee list$")
        public void i_select_name_from_employee_list(String firstName, String lastName) throws Throwable {
    	this.homePage.clickNameFromList(firstName, lastName);
    }

    @When("^I click delete on home page$")
    public void i_click_delete_on_home_page() throws Throwable {
    	this.homePage.clickDeleteButton();
    }

    @When("^I accept delete alert$")
    public void i_accept_delete_alert() throws Throwable {
    	this.homePage.acceptDeleteAlert();
    }

    @Then("^I should not see employee with name \"(.*?)\", \"(.*?)\" in the list$")
    public void i_should_not_see_employee_with_name_in_list(String firstName, String lastName) throws Throwable {
        this.homePage.assertNameNotExist(firstName, lastName);
    }

    @When("^I click on edit employee$")
    public void i_click_on_edit_employee() throws Throwable {
        this.homePage.clickEditButton();
    }

    @When("^I click delete on edit page$")
    public void i_click_delete_on_edit_page() throws Throwable {
        this.createPage.clickDeleteButton();
    }
}
