package driver;

import org.openqa.selenium.WebDriver;

public interface DriverInterface {
	public WebDriver get();
    public void close();
	public void configure(String url);
}
