package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(tags = "", features = {"src/test/java/Features"}, glue = {"StepDefinition"},
        plugin = {})

public class Runner extends AbstractTestNGCucumberTests {

}