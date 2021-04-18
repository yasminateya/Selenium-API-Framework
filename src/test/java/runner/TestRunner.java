package runner;

import cucumber.api.CucumberOptions;
import tests.TestBase;


@CucumberOptions(features = "src/test/java/features"
        , glue = {"stepsDefinition"}
        , plugin = {"pretty", "html:target/cucumber-html-report"}) // to generate html report
public class TestRunner extends TestBase {

}
