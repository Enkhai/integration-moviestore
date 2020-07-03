Feature: Index page

  Background:
    Given The browser opens and the index page loads

  @indexPageScenario
  Scenario: Index page title
    Given the index page reloads
    Then verify the index page title

  @indexPageScenario
  Scenario: Index popular movie redirect
    Given the index page reloads
    Then verify the user can view a popular movie
