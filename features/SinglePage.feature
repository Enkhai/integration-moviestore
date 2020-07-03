Feature: Single page

  Background:
    Given The browser opens and the single page loads

  @singlePageScenario
  Scenario: Single page title
    Given the single page reloads
    Then verify the single page title

  @singlePageScenario
  Scenario: Single page redirects to home page
    Given the single page reloads
    Then verify the user can go to the home page

  @singlePageScenario
  Scenario: Single page comment number should be correct
    Given the single page reloads
    Then verify the number of comments displayed is correct

  @singlePageScenario
  Scenario: Similar movie link in the single page should work
    Given the single page reloads
    Then verify the user can view a similar movie