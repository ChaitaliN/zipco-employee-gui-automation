package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import driver.Driver;
import webpage.HomePage;
import webpage.LoginPage;

public class Logout implements StepDefinition {

    String adminUsername = "Luke";
    String adminPassword = "Skywalker";

    public Driver driver;
    public LoginPage loginPage;
    public HomePage homePage;

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
    }

    @Given("^I am logged in as Luke to logout back$")
    public void i_am_logged_in_as_Luke_to_logout_back() throws Throwable {

        this.initialize();
        this.driver.navigateToHomePage();
        this.loginPage.formDisplay();
        this.loginPage.enterUsername(this.adminUsername);
        this.loginPage.enterPassword(this.adminPassword);
        this.loginPage.clickLogin();
    }

    @When("^I click logout button$")
    public void i_click_logout_button() throws Throwable {
        this.homePage.clickLogout();
    }

    @Then("^I should be back on login page$")
    public void i_should_be_back_on_login_page() throws Throwable {
        this.loginPage.formDisplay();
    }
}
