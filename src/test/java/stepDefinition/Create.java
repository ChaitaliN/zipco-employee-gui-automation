package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import driver.Framework;
import webpage.HomePage;
import webpage.LoginPage;

public class Create {

    String adminUsername = "Luke";
    String adminPassword = "Skywalker";

    public Framework framework;
    public LoginPage loginPage;
    public HomePage homePage;

    @Before()
    public void setup() {
        framework = new Framework();
        loginPage = new LoginPage(framework.getDriver());
        homePage = new HomePage(framework.getDriver());
    }

	@Given("^I am logged in as Luke$")
	public void i_am_logged_in_as_luke() throws Throwable {
        this.loginPage.formDisplay();
        this.loginPage.enterUsername(this.adminUsername);
        this.loginPage.enterPassword(this.adminPassword);
        this.loginPage.clickLogin();
	}

	@Given("^I am on the landing page$")
	public void i_am_on_the_landing_page() throws Throwable {
        System.out.println("in landing page");
        this.homePage.employeeListDisplay();
	}

	@When("^I click the Create button$")
	public void i_click_the_create_button() throws Throwable {
        System.out.println("in click create");
	}

    @When("^I enter employee firstname \"([^\"]*)\"$")
    public void i_enter_employee_firstname(String firstName) throws Throwable {
        System.out.println(firstName);
    }

    @When("^I enter employee lastname \"([^\"]*)\"$")
    public void i_enter_employee_lastname(String lastName) throws Throwable {
        System.out.println(lastName);
    }

    @When("^I enter employee startDate \"([^\"]*)\"$")
    public void i_enter_employee_startDate(String startDate) throws Throwable {
        System.out.println(startDate);
    }

    @When("^I enter employee email \"([^\"]*)\"$")
    public void i_enter_employee_email(String email) throws Throwable {
        System.out.println(email);
    }

	@When("^I click on Add button$")
	public void user_submit_the_Create_form() throws Throwable {
        System.out.println("in add button");
	}

    @When("^I select newly created employee name from the list \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_select_newly_created_employee_name_from_the_list(String firstName,
            String lastName) throws Throwable {
        System.out.println("in list");
    }

    @Then("^I should see correct details for newly created employee \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_should_see_correct_details_for_newly_created_employee(String firstName,
            String lastName, String startDate, String email) throws Throwable {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(startDate);
        System.out.println(email);
    }

	@After
	public void teardown() {
        this.framework.closeDriver();
	}
}
