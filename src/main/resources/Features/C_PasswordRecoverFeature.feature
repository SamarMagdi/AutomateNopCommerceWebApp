@SmokeScnario
Feature: Feature to test password recover functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC3- User could reset his/her password successfully
    #user is in login page and forget password
    Given   user choose forget password
    #user choose forget password link and add his email
    When    fill email and click recovery button
    #Confirmation message should appear to user to check mail
    Then    Confirmation message should appear