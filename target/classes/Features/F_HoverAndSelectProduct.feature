@SmokeScnario
Feature: Feature to test Hover and Select Product functionality in Nop Commerce web application

  @SmokeTest
  Scenario: SC6- Logged user could select different Categories
    #user login to Application
    Given   login to Application
    #Hover over any category and select subcategory
    When    Hover over any category and select subcategory
    #the sub category page should appear correctly
    Then    sub category page should appear correctly