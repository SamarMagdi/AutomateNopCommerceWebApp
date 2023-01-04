@SmokeScnario
Feature: Feature to Create Successful Order in Nop Commerce web application

  @SmokeTest
  Scenario: SC12- Create successful Order
    #user login Successfully to Nop Commerce App
    Given   user login Successfully to Nop Commerce App
    #user click go to card button and complete checkout
    When    user click go to card button and complete checkout
    #order should created successfully
    Then    order should created successfully