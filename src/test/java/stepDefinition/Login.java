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

public class Login implements StepDefinition {

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

    public void iniatialize() throws Throwable {
        this.driver.start();
        this.loginPage = new LoginPage(this.driver.get());
        this.homePage = new HomePage(this.driver.get());
        this.createPage = new CreatePage(this.driver.get());
    }

    @Given("^I am on login page with title \"([^\"]*)\"$")
    public void i_am_on_login_page_with_title(String title) throws Throwable {
        this.iniatialize();
        this.driver.navigateToHomePage();
        this.loginPage.assertTitle(title);
    }

    @Given("^I see login form displayed$")
    public void i_see_login_form_displayed() throws Throwable {
        this.loginPage.formDisplay();
    }

    @When("^I enter username \"([^\"]*)\"$")
    public void i_enter_username(String name) throws Throwable {
	    this.loginPage.enterUsername(name);
    }

    @When("^I enter password \"([^\"]*)\"$")
    public void i_enter_password(String password) throws Throwable {
	    this.loginPage.enterPassword(password);
    }

    @When("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {
	    this.loginPage.clickLogin();
    }

    @Then("^I should see \"([^\"]*)\" in greeting message$")
    public void i_should_see_in_greeting_message(String name) throws Throwable {
	    this.homePage.checkGreetingMsg(name);
    }

	@Then("^I should see \"([^\"]*)\"$")
	public void user_should_see(String message) throws Throwable {
		this.loginPage.checkErrorMsg(message);
	}
}
