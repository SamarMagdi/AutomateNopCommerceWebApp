#this automation script created by shady ahmed
@SmokeScnario
Feature: Feature to test login functionality to Nop Commerce web application

  @SmokeTest
    # User could log in with valid email and password
  Scenario: SC2- User could log in with valid email and password
    #user is in login page
    Given   user is in login page
    #user add valid username and password and click login button
    When    user add valid username and password and click login button
    #user navigate to home page
    Then    user navigate to home page
