@SmokeScnario
Feature: Feature to test select different tags in Nop Commerce web application

  @SmokeTest
  Scenario: SC8- Logged user could select different tags
    #user login to the app
    Given  login to application
    #user select hover Computers categories and select Notebooks sub category
    When    select hover Computers categories and select Notebooks sub category
    #Notebooks page should start correctly
    Then    Notebooks page should start correctly
    #user select hover Apparel categories and select Shoes sub category
    And     select hover Apparel categories and select Shoes sub category
    #Shoes page should appear correctly
    Then    Shoes page should appear correctly