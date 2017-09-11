package com.optum.stepDefs;

import com.optum.base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.optum.pageobjects.CommentTextPage;

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
        page = CommentTextPage.visitPage(base.driver);
    }

    @When("^I submit a comment$")
    public void iSubmitAComment() throws Throwable {
        commentInputText = UUID.randomUUID().toString();
        page.submitComment(commentInputText);
    }

    @Then("^I should see that comment displayed$")
    public void iShouldSeeThatCommentDisplayed() throws Throwable {
        assertThat(page.getSubmittedCommentText(), containsString(commentInputText));
    }
}
