package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {

    final private String propFileName = "test.config.properties";
    private String chromeBrowser = "chrome";
	private Properties prop;
	private static WebDriver driver;

    public Driver() {

        // NOTE: Throwing exception from constructors
        // isn't a good practice
        try {
            // Load properties
            this.loadProperties();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {

        System.out.println("in driver");
        if (this.prop.getProperty("browser").toLowerCase().equals(chromeBrowser)) {
		    System.setProperty("webdriver.chrome.driver",
                    this.prop.getProperty("chromedriver.location"));
            this.driver = new ChromeDriver();
            System.out.println("start chrome");
        } else {
            System.setProperty("webdriver.gecko.driver",
                    this.prop.getProperty("firefoxdriver.location"));
            this.driver = new FirefoxDriver();
            System.out.println("start firefox");
        }
    }

	public void navigateToUrl() {
        this.start();
		this.driver.manage().window().maximize();
		this.driver.get(this.prop.getProperty("url"));
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

    public void quit() {
        this.driver.quit();
    }

    public WebDriver get() {
        return this.driver;
    }

    public Properties getProperties() {
        return this.prop;
    }

    private void loadProperties() throws Exception {

        this.prop = new Properties();
        InputStream inputStream;

        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                this.prop.load(inputStream);
                inputStream.close();
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            e.printStackTrace();
		}
	}
}
