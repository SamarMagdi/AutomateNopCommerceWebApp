@SmokeScnario
Feature: Feature to test registration functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC1- User could register with valid data
    #user is in main page
    Given   user is in main page
    #user choose register tap
    When    choose register tap
    #fill all data and click register button
    And     fill all data
    #user navigate to user page
    Then    navigate to user page