Feature: MVP TurnUp portal login feature
 As a registerred user
  I want to log in to the application
  So that i can access my personalized dashboard

  A short summary of the feature

  @regression
  Scenario: Successful login with valid Credentials
    Given the user navigates to the login page
    When user enters valid credentials and click the login button
    Then the user should be redirected to the homepage
