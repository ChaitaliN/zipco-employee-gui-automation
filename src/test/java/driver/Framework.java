package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Framework {

    final private String propFileName = "test.config.properties";
    private String chromeBrowser = "chrome";
	private Properties prop;
	private DriverInterface driver;

    public Framework() {

        // NOTE: Throwing exception from constructors
        // isn't a good practice
        try {
            // Load properties
            this.loadProperties();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get driver
        if (this.prop.getProperty("browser").toLowerCase().equals(chromeBrowser)) {
            this.driver = new ChromeDriverShim(
                    this.prop.getProperty("chromedriver.location"));
        } else {
            this.driver = new FirefoxDriverShim(
                    this.prop.getProperty("firefoxdriver.location"));
        }

        // Configure driver
        this.driver.configure(this.prop.getProperty("url"));
    }

    public DriverInterface getDriver() {
        return this.driver;
    }

    public void closeDriver() {
        this.driver.close();
    }

    public Properties getProperties() {
        return this.prop;
    }

    public void loadProperties() throws Exception {

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
