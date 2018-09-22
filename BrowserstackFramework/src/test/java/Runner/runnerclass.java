package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty","html:target/cucumber"},
        features ="src/test/resource/FirstFeature.feature",
        strict=true,
        monochrome= true,
        glue = {"StepDefinitions"}, tags={"@Test,@Test1"}
)

public class runnerclass {

}
