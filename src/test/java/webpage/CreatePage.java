package webpage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CreatePage {

	public static JavascriptExecutor js;
	public WebDriver driver;

	public CreatePage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(name="employeeForm")
	WebElement detailForm;

	@FindBy(xpath="//input[@ng-model='selectedEmployee.firstName']")
	WebElement firstNameInput;

	@FindBy(xpath="//input[@ng-model='selectedEmployee.lastName']")
	WebElement lastNameInput;

	@FindBy(xpath="//input[@ng-model='selectedEmployee.startDate']")
	WebElement startDateInput;

	@FindBy(xpath="//input[@ng-model='selectedEmployee.email']")
	WebElement emailInput;

	@FindBy(xpath="//button[@class='main-button']")
	WebElement createAddButton;

	@FindBy(className="bCancel")
	WebElement createCancelButton;

	@FindBy(xpath="//*[@class='formFooter']/p")
	WebElement deleteButton;

	@FindBy(xpath="//*[@class='formFooter']/button[1]")
	WebElement updateButton;

	@FindBy(className="bBack")
	WebElement backEditButton;

	public void enterFirstName(String firstName) throws Exception {
		firstNameInput.clear();
		firstNameInput.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameInput.clear();
		lastNameInput.sendKeys(lastName);
	}

	public void enterStartDate(String startDate) {
		startDateInput.clear();
		startDateInput.sendKeys(startDate);
	}

	public void enterEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void clickAddButton() {
		createAddButton.click();
	}

	public void clickCancelButton(){
		createCancelButton.click();
	}

	public void clickBackButton(){
		backEditButton.click();
	}

	public void acceptAlert() {
		try {
	        WebDriverWait wait = new WebDriverWait(this.driver, 5);
	        if(wait.until(ExpectedConditions.alertIsPresent()) != null) {
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = this.driver.switchTo().alert();
		        alert.accept();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    // Validation methods
	public void assertFirstName(String firstName){
		js = (JavascriptExecutor) this.driver;
		String actualFirstName = js.executeScript("return document.querySelectorAll('input')[0].value").toString();
		assertEquals(firstName, actualFirstName);
	}

	public void assertLastName(String lastName){
		js = (JavascriptExecutor) this.driver;
		String actualLastName = js.executeScript("return document.querySelectorAll('input')[1].value").toString();
		assertEquals(lastName, actualLastName);
	}

	public void assertStartDate(String startDate){
		js = (JavascriptExecutor) this.driver;
		String actualDate = js.executeScript("return document.querySelectorAll('input')[2].value").toString();
		assertEquals(startDate, actualDate);
	}

	public void assertEmail(String email){
		js = (JavascriptExecutor) this.driver;
		String actualEmail = js.executeScript("return document.querySelectorAll('input')[3].value").toString();
		assertEquals(email, actualEmail);
	}

	public void checkAddBtnDisable() {
		String addBtnStatus = createAddButton.getAttribute("ng-disabled");
		assertEquals("true", addBtnStatus);
	}

	public void clickDeleteButton(){
		deleteButton.click();
	}

	public void clickUpdateButton(){
		updateButton.click();
	}
}
