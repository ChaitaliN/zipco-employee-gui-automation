package webpage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class HomePage {

    public WebDriver driver;

	public HomePage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id="greetings")
	WebElement greeting;

	@FindBy(id="employee-list")
	WebElement employeeList;

	@FindBy(id="bAdd")
	WebElement createButton;

	@FindBy(id="bDelete")
	WebElement deleteButton;

	@FindBy(className="bBack")
	WebElement editBackButton;

	@FindBy(id="bEdit")
	WebElement editButton;

	@FindBy(xpath="//*[@id='employee-list']/li")
	List<WebElement> employeeNames;

	@FindBy(xpath="//*[@class='header-container']/p[1]")
	WebElement logoutButton;

	public void checkGreetingMsg(String name) throws Throwable {
	    String greetMsg = greeting.getText();
	    assertEquals("Hello"+ " " + name, greetMsg);
	    // Thread.sleep(3000);
	}

	public void employeeListDisplay() throws Exception{
		// this.waitLoop(employeeList);
		employeeList.isDisplayed();
	}

	public void clickCreateButton() {
		createButton.click();
	}

	public void clickBackButton(){
		editBackButton.click();
	}

	public void clickDeleteButton() {
		deleteButton.click();
	}

	public void clickEditButton(){
		editButton.click();
	}

	public void clickLogout(){
		logoutButton.click();
	}

	public void doubleClickNameFromList(String firstName, String lastName) throws Exception {
		// this.waitLoop(employeeList);
		Actions action = new Actions(this.driver);
		for (WebElement empName: employeeNames) {
			String fullName = empName.getText();
			if (fullName.equals(firstName+" "+lastName)) {
				action.doubleClick(empName).perform();
				// Thread.sleep(1000);
				break;
			}
		}
	}

	public void clickNameFromList(String firstName, String lastName) throws Exception {
		// this.waitLoop(employeeList);
		for (WebElement empName: employeeNames) {
			String fullName = empName.getText();
			if(fullName.equals(firstName+" "+lastName)) {
				empName.click();
				// Thread.sleep(2000);
				break;
			}
		}
	}

	public void selectNameFromList(String firstName, String lastName) throws Exception{
		// wait.waitLoop(employeeList);
		for (WebElement empName: employeeNames) {
			String fullName = empName.getText();
			if(fullName.equals(firstName+" "+lastName)){
				empName.click();
				// Thread.sleep(2000);
				break;
			}
		}
	}

	public void acceptDeleteAlert() {
		try {
	        WebDriverWait wait = new WebDriverWait(this.driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = this.driver.switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
            e.printStackTrace();
	    }
	}

    // Validation methods
	public void assertNameNotExist(String firstName, String lastName) throws Exception{
		// this.waitLoop(employeeList);
		for (WebElement empName: employeeNames) {
			String fullName = empName.getText();
			assertTrue(fullName != (firstName+" "+lastName));
		}
	}
}
