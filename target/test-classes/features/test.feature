Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the following for Login
      | Username | Password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page

#  Scenario Outline: Login with correct username and password using scenario outline
#    Given I navigate to the login page
#    And I enter <Username> and <Password>
#    And I click login button
#    Then I should see the userform page
#
#    Examples:
#      | Username | Password   |
#      | execute  | automation |
#      | testing  | QA         |