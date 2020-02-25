package webpage;

import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseWebPage {

    public LoginPage() {
        PageFactory.initElements(this.getDriver(), this);
    }

}
