package com.company.stepDefs;

import com.company.base.BaseUtil;
import com.company.pageobjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginStep extends BaseUtil {

    private BaseUtil base;
    public static LoginPage page;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        page = LoginPage.visitPage(base.driver);
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        page.ClickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        page.isDisplayed();
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) throws Throwable {
        page.Login(userName, password);
    }

}
