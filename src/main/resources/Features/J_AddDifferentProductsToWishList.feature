@SmokeScnario
Feature: Feature to test add different products to White List in Nop Commerce web application

  @SmokeTest
  Scenario: SC10- Logged user could add different products to Wishlist
    #user login correctly to the app
    Given   login correctly to app
    #user add one product from Notebooks in computer category to White List
    When    add one product from Notebooks in computer category to Wish List
    #user add one product from Shoes in Apparel category to White List
    And     add one product from Shoes in Apparel category to Wish List
    #the selected two products should added correctly
    Then    the selected two products should added correctly