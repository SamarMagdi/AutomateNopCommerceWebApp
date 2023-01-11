@SmokeScnario
Feature: Feature to test Change Currency functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC5- Logged User could switch between currencies US-Euro
    #user login to nop commerce
    Given   login to an application
    #change current currency to another
    When    change current currency to another
    #currency should changed correctly
    Then    currency should change correctly