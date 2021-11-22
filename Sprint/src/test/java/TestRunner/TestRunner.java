package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\redavid\\eclipse-workspace\\Sprint\\src\\test\\java\\Features",
        glue= {"StepDefinition"})

public class TestRunner {
	
}

