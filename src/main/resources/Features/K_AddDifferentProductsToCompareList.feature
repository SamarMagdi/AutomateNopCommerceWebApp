@SmokeScnario
Feature: Feature to test add different products to Compare List in Nop Commerce web application

  @SmokeTest
  Scenario: SC11- Logged user could add different products to compare list
    #user login Successfully
    Given   login Successfully
    #user add one product from Notebooks in computer category to Compare List
    When    add one product from Notebooks in computer category to Compare List
    #user add one product from Shoes in Apparel category to Compare List
    And     add one product from Shoes in Apparel category to Compare List
    #the selected two products should added and appear correctly
    Then    the selected two products should added and appear correctly