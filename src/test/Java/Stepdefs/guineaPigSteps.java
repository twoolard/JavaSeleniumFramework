package Stepdefs;

import Base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CommentTextPage;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;


public class guineaPigSteps extends BaseUtil {
    private BaseUtil base;
    public static CommentTextPage page;
    public String commentInputText;

    public guineaPigSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I am on the Guinea Pig homepage$")
    public void iAmOnTheGuineaPigHomepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        page = CommentTextPage.visitPage(base.driver);
    }

    @When("^I submit a comment$")
    public void iSubmitAComment() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commentInputText = UUID.randomUUID().toString();
        page.submitComment(commentInputText);
    }

    @Then("^I should see that comment displayed$")
    public void iShouldSeeThatCommentDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(page.getSubmittedCommentText(), containsString(commentInputText));

    }
}
