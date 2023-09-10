package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(
		features = {"src/test/java/features/"},
		dryRun = !true,
	    glue = {"steps","hooks"},
	    snippets = SnippetType.CAMELCASE,
	    monochrome = true,
	    plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//	    plugin = {"pretty",
//	    		"html:target/cucumber/report.html",
//	    		"json:target/cucumber/result.json",
//	    		"junit:target/cucumber/result.xml"}
		// tags = "@login"
		)



public class RunnerTs extends AbstractTestNGCucumberTests  {
	



}
