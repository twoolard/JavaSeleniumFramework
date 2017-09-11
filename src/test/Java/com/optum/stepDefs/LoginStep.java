package com.optum.stepDefs;

import com.optum.base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.optum.pageobjects.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;
    public static LoginPage page;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    public class User
    {
        public String username;
        public String password;

        public User(String userName, String Password) {
            username = userName;
            password = Password;
        }
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        page = LoginPage.visitPage(base.driver);
    }

    @And("^I enter the following for Login$")
    public void i_enter_the_following_for_Login(DataTable table) throws Throwable {
//        List<List<String>> data = table.raw();
//        String username = data.get(0).get(1).toString();
//        String Password = data.get(1).get(1).toString();
//
//        System.out.println("The Value for username is: " + username);
//        System.out.println("The Value for password is: " + Password);

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);

        for (User user: users){
            page.Login(user.username, user.password);
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        page.ClickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        page.isDisplayed();
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("userName is: " + userName);
        System.out.println("password is: " + password);
    }

}
