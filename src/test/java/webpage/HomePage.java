package webpage;

import driver.DriverInterface;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BaseWebPage {

	public DriverInterface driver;

	public HomePage(DriverInterface driver) {
        this.driver = driver;
        this.setInitElement(this.driver);
	}

	@FindBy(id="employee-list")
	WebElement employeeList;

	@FindBy(id="bAdd")
	WebElement createButton;

	@FindBy(xpath="//*[@id='employee-list']/li")
	List<WebElement> employeeNames;

	public void employeeListDisplay() throws Exception{
		// this.waitLoop(employeeList);
		employeeList.isDisplayed();
	}

	public void clickCreateButton() {
		createButton.click();
	}

	public void doubleClickNameFromList(String firstName, String lastName) throws Exception{
		// this.waitLoop(employeeList);
		Actions action = new Actions(this.driver.get());
		for (WebElement empName: employeeNames){
			String fullName = empName.getText();
			if(fullName.equals(firstName+" "+lastName)){
				action.doubleClick(empName).perform();
				// Thread.sleep(1000);
				break;
				}
			}
	}


}
