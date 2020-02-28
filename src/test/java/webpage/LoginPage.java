package webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginPage {

    public WebDriver driver;

	public LoginPage(WebDriver driver) {
        this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id="login-form")
    WebElement loginForm;

	@FindBy(xpath="//input[@ng-model='user.name']")
	WebElement username;

	@FindBy(xpath="//input[@ng-model='user.password']")
	WebElement password;

	@FindBy(xpath="//button[text()='Login']")
	WebElement loginButton;

	@FindBy(className="error-message")
	WebElement errorMessage;

	public void formDisplay() throws Throwable {
		loginForm.isDisplayed();
	}

	public void enterUsername(String name) throws Throwable {
	    username.clear();
	    username.sendKeys(name);
	}

	public void enterPassword(String pass) throws Throwable {
	    password.clear();
	    password.sendKeys(pass);
	}

	public void clickLogin() throws Throwable {
	    loginButton.click();
	}

	public void assertTitle(String title) throws Throwable {
	    String browserTitle = this.driver.getTitle();
		assertEquals(title, browserTitle);
	}

	public void checkErrorMsg(String actual) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		String expected = errorMessage.getText();
		assertEquals(actual, expected);
	}
}
