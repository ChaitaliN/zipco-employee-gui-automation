package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirefoxDriverShim implements DriverInterface {

    final private String defaultDriverBinary = "./bin/darwin/geckodriver";
	private static WebDriver driver;

    public FirefoxDriverShim() {
		System.setProperty("webdriver.gecko.driver", defaultDriverBinary);
        this.driver = new FirefoxDriver();
    }

    public FirefoxDriverShim(String driverBinary) {
		System.setProperty("webdriver.gecko.driver", driverBinary);
        this.driver = new FirefoxDriver();
    }

	public WebDriver get(){
		return this.driver;
	}

    public void close() {
        this.driver.close();
    }

	public void configure(String url) {
		this.driver.manage().window().maximize();
		this.driver.get(url);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
