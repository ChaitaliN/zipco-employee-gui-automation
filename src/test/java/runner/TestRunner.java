package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import util.Driver;
import webpage.BaseWebPage;

import java.io.IOException;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
            "html:target/cucumber-html-report",
			"json:target/cucumber.json",
            "pretty:target/cucumber-pretty.txt",
			"usage:target/cucumber-usage.json",
            "junit:target/cucumber-results.xml"
        },
		features = "src/test/resources/feature",
		glue={"stepDefinition"}
		)


public class TestRunner {

	   @AfterClass
	   public static void tearDown() {
	     Driver driver = new Driver();
	     driver.close();
	   }

}
