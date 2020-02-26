// package stepDefinition;
//
// import cucumber.api.java.en.Given;
// import cucumber.api.java.en.Then;
// import cucumber.api.java.en.When;
// import cucumber.api.java.Before;
// import cucumber.api.java.After;
// import driver.Framework;
// import webpage.CreatePage;
// import webpage.HomePage;
// import webpage.LoginPage;
//
// public class Delete {
//
//     String adminUsername = "Luke";
//     String adminPassword = "Skywalker";
//
//     public Framework framework;
//     public LoginPage loginPage;
//     public HomePage homePage;
//     public CreatePage createPage;
//
//     @Before("@create-employee")
//     public void setup() {
//         framework = new Framework();
//         loginPage = new LoginPage(framework.getDriver());
//         homePage = new HomePage(framework.getDriver());
//         createPage = new CreatePage(framework.getDriver());
//     }
//
// 	@Given("^I am logged in as Luke to delete employee$")
// 	public void i_am_logged_in_as_luke_to_delete_employee() throws Throwable {
//         this.loginPage.formDisplay();
//         this.loginPage.enterUsername(this.adminUsername);
//         this.loginPage.enterPassword(this.adminPassword);
//         this.loginPage.clickLogin();
// 	}
//
//     @Given("^I select name \"([^\"]*)\", \"([^\"]*)\" from employee list$")
//         public void i_select_name_from_employee_list(String firstName, String lastName) throws Throwable {
//     	this.homePage.clickNameFromList(firstName, lastName);
//     }
//
//     @When("^I click Delete on home page$")
//     public void i_click_delete_on_home_page() throws Throwable {
//     	this.homePage.clickDeleteButton();
//     }
//
//     @When("^I accept delete alert$")
//     public void i_accept_delete_alert() throws Throwable {
//     	this.homePage.acceptDeleteAlert();
//     }
//
//     @Then("^I should not see employee with name \"(.*?)\", \"(.*?)\" in the list$")
//     public void i_should_not_see_employee_with_name_in_list(String firstName, String lastName) throws Throwable {
//         this.homePage.assertNameNotExist(firstName, lastName);
//     }
//
// 	@After
// 	public void teardown() {
//         this.framework.closeDriver();
// 	}
// }
