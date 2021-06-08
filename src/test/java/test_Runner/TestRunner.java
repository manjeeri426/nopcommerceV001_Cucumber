package test_Runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features=".//Features/Customers.feature",
		glue="step_Definitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"},
		tags= {"@Regression"}
)
public class TestRunner {

}
