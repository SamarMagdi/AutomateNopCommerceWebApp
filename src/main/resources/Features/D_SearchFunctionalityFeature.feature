@SmokeScnario
Feature: Feature to test search functionality to Nop Commerce web application

  @SmokeTest
  Scenario: SC4- Logged User could search for any product
    #user login to nop commerce web application
    Given   user login to nop commerce web application
    #search for product
    When    search for product
    #results should appear correctly
    Then    results should appear correctly