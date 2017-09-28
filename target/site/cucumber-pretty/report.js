$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CommentText.feature");
formatter.feature({
  "line": 1,
  "name": "Guinea Pig comment",
  "description": "",
  "id": "guinea-pig-comment",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2993224982,
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
  "duration": 902508842,
  "status": "passed"
});
formatter.match({
  "location": "guineaPigSteps.iSubmitAComment()"
});
formatter.result({
  "duration": 285380760,
  "status": "passed"
});
formatter.match({
  "location": "guineaPigSteps.iShouldSeeThatCommentDisplayed()"
});
formatter.result({
  "duration": 40211103,
  "status": "passed"
});
formatter.after({
  "duration": 70903480,
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
formatter.scenarioOutline({
  "line": 4,
  "name": "Login with correct username and password using scenario outline",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password-using-scenario-outline",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter \u003cUsername\u003e and \u003cPassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click login button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should see the userform page",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password-using-scenario-outline;",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 11,
      "id": "loginfeature;login-with-correct-username-and-password-using-scenario-outline;;1"
    },
    {
      "cells": [
        "execute",
        "automation"
      ],
      "line": 12,
      "id": "loginfeature;login-with-correct-username-and-password-using-scenario-outline;;2"
    },
    {
      "cells": [
        "testing",
        "QA"
      ],
      "line": 13,
      "id": "loginfeature;login-with-correct-username-and-password-using-scenario-outline;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2451589193,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Login with correct username and password using scenario outline",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password-using-scenario-outline;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter execute and automation",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click login button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should see the userform page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iNavigateToTheLoginPage()"
});
formatter.result({
  "duration": 1181215324,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "execute",
      "offset": 8
    },
    {
      "val": "automation",
      "offset": 20
    }
  ],
  "location": "LoginStep.iEnterUsernameAndPassword(String,String)"
});
formatter.result({
  "duration": 635125854,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickLoginButton()"
});
formatter.result({
  "duration": 372230986,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheUserformPage()"
});
formatter.result({
  "duration": 1585072098,
  "status": "passed"
});
formatter.after({
  "duration": 84736762,
  "status": "passed"
});
formatter.before({
  "duration": 2401887798,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Login with correct username and password using scenario outline",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password-using-scenario-outline;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter testing and QA",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click login button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should see the userform page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iNavigateToTheLoginPage()"
});
formatter.result({
  "duration": 845315066,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testing",
      "offset": 8
    },
    {
      "val": "QA",
      "offset": 20
    }
  ],
  "location": "LoginStep.iEnterUsernameAndPassword(String,String)"
});
formatter.result({
  "duration": 488181042,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickLoginButton()"
});
formatter.result({
  "duration": 312738252,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheUserformPage()"
});
formatter.result({
  "duration": 1611490656,
  "status": "passed"
});
formatter.after({
  "duration": 81641444,
  "status": "passed"
});
});