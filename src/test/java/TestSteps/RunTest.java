package TestSteps;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(features = ".",format = {"html:target/site/cucumber-pretty","json:target/cucumber.json"},glue = "TestSteps")
public class RunTest extends AbstractTestNGCucumberTests{
}
