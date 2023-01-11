#this automation script created by shady ahmed
@SmokeScnario
Feature: Feature to test login functionality to Nop Commerce web application

  @SmokeTest
    # User could log in with valid email and password
  Scenario: SC2- User could log in with valid email and password
    #user is in login page
    Given   user in login page
    #user add valid username and password and click login button
    When    add valid username and password
    #user navigate to home page
    Then    navigate to home page
