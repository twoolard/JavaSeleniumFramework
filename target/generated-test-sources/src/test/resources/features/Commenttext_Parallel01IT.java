import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"/home/docker/IdeaProjects/learning_cucumber_automationframework/src/test/resources/features/CommentText.feature"},
plugin = {"junit:/home/docker/IdeaProjects/learning_cucumber_automationframework/target/cucumber_reports/${gitsuitename}_results/1.junit"},
monochrome = true,
 tags = {"~@ignore"}, glue = { "com.company.stepDefs" })
public class Commenttext_Parallel01IT {
}
