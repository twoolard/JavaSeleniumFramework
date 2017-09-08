import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"C:/Users/twoolard/ProjectsbyTerry/learning_cucumber_automationframework/src/test/Java/features/CommentText.feature"},
plugin = {"junit:target/cucumber-parallel/1.junit"},
monochrome = true,
 tags = {}, glue = { "Stepdefs" })
public class Parallel01IT {
}
