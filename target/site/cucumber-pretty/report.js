$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CommentText.feature");
formatter.feature({
  "line": 1,
  "name": "Guinea Pig comment",
  "description": "",
  "id": "guinea-pig-comment",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6176225071,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Can submit comment",
  "description": "",
  "id": "guinea-pig-comment;can-submit-comment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am on the Guinea Pig homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I submit a comment",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I should see that comment displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "guineaPigSteps.iAmOnTheGuineaPigHomepage()"
});
formatter.result({
  "duration": 1414837067,
  "status": "passed"
});
formatter.match({
  "location": "guineaPigSteps.iSubmitAComment()"
});
formatter.result({
  "duration": 590544343,
  "status": "passed"
});
formatter.match({
  "location": "guineaPigSteps.iShouldSeeThatCommentDisplayed()"
});
formatter.result({
  "duration": 47373625,
  "status": "passed"
});
formatter.after({
  "duration": 67143561,
  "status": "passed"
});
formatter.uri("test.feature");
formatter.feature({
  "line": 1,
  "name": "LoginFeature",
  "description": "This feature deals with the login functionality of the application",
  "id": "loginfeature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2364931147,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login with correct username and password",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter the following for Login",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 7
    },
    {
      "cells": [
        "admin",
        "adminpassword"
      ],
      "line": 8
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I click login button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I should see the userform page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iNavigateToTheLoginPage()"
});
formatter.result({
  "duration": 1463723775,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.i_enter_the_following_for_Login(DataTable)"
});
formatter.result({
  "duration": 671445194,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickLoginButton()"
});
formatter.result({
  "duration": 551766936,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheUserformPage()"
});
formatter.result({
  "duration": 61173300,
  "status": "passed"
});
formatter.after({
  "duration": 71595992,
  "status": "passed"
});
});