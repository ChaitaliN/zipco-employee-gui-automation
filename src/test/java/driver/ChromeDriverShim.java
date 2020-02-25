package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverShim implements DriverInterface {

    final private String defaultDriverBinary = "./bin/darwin/chromedriver";
	private static WebDriver driver;

    public ChromeDriverShim() {
		System.setProperty("webdriver.chrome.driver", defaultDriverBinary);
        this.driver = new ChromeDriver();
    }

    public ChromeDriverShim(String driverBinary) {
		System.setProperty("webdriver.chrome.driver", driverBinary);
        this.driver = new ChromeDriver();
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
