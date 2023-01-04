@SmokeScnario
Feature: Feature to test filter Products with color functionality in Nop Commerce web application

  @SmokeTest
  Scenario: SC7- Logged user could filter with color
    #user login to the application
    Given   user login to the application
    #user select subcategory and filter with specific color
    When    user select subcategory and filter with specific color
    #filtered results should appear correctly
    Then    filtered results should appear correctly