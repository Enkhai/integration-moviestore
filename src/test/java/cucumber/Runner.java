package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// features is the directory of the features, glue is the package of the step definitions
@CucumberOptions(features = "features", glue = {"cucumber.stepDefinitions"})
public class Runner {

}