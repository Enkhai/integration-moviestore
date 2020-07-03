Feature: Generic page functionality

  Background:
    Given The browser opens and a generic page loads

  @genericPageScenario
  Scenario: Pressing the login button the user should be redirected to the login page
    Given the generic page reloads
    Then verify the user is redirected to the login page

  @genericPageScenario
  Scenario: Selecting a category from the dropdown menu should redirect the user to the appropriate page
    Given the generic page reloads
    Then verify the user can view a category from the dropdown menu

  @genericPageScenario
  Scenario: Selecting the Popular, Upcoming the Top Rated pages from the dropdown menu the user should be redirected to the appropriate page
    Given the generic page reloads
    Then verify the user can view each of the Popular, Upcoming and Top Rated categories from the dropdown menu

  @genericPageScenario
  Scenario: Users should be able to search a specific movie
    Given the generic page reloads
    Then verify the user can search for a specific movie by title

  @genericPageScenario
  Scenario: Selecting a category from the footer should redirect the user to the appropriate page
    Given the generic page reloads
    Then verify the user can view a category from the footer

  @genericPageScenario
  Scenario: Selecting the Popular, Upcoming the Top Rated pages from the footer the user should be redirected to the appropriate page
    Given the generic page reloads
    Then verify the user can view each of the Popular, Upcoming and Top Rated categories from the footer
