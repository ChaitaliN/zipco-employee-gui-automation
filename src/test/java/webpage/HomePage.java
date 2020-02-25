package webpage;

import driver.DriverInterface;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseWebPage {

	public HomePage(DriverInterface driver) {
        this.setInitElement(driver);
	}

	@FindBy(id="employee-list")
	WebElement employeeList;

	public void employeeListDisplay() throws Exception{
		// wait.waitLoop(employeeList);
		employeeList.isDisplayed();
	}


}
