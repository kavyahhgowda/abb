package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "featurefiles",
glue={"stepdefinitions","hooks"},dryRun = false,
plugin = "html:target/report.html"
,tags = "@CustomerModule"
)
public class RunnerClass extends AbstractTestNGCucumberTests{
}