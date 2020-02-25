package driver;

import org.openqa.selenium.WebDriver;

public interface Driver {
	public WebDriver get();
    public void close();
	public void configure(String url);
}
