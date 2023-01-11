@SmokeScnario
Feature: Feature to test filter Products with color functionality in Nop Commerce web application

  @SmokeTest
  Scenario: SC7- Logged user could filter with color
    #user login to the application
    Given   login to nop application
    #user select subcategory and filter with specific color
    When    select subcategory and filter with specific color
    #filtered results should appear correctly
    Then    filtered results should appear correctly