Feature: Login page

  Background:
    Given The browser opens and the login page loads

  @loginPageScenario
  Scenario: The sign up button should redirect to TMDb
    Given the login page reloads
    Then verify the user is redirected to sign up

  @loginPageScenario
  Scenario: The "Forgot password?" button should redirect to TMDb
    Given the login page reloads
    Then verify the user is redirected for a new password

  @loginPageScenario
  Scenario: The user should be able to successfully log in and log out
    Given the login page reloads
    Then verify the user should be able to login and then log out

  @loginPageScenario
  Scenario: Failing to log in should display an error message
    Given the login page reloads
    Then verify a Wrong Credentials message is displayed