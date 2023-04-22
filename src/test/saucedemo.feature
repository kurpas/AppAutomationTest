@Login
Feature: The user login into the Sauce demo

  Scenario: The user login into the Sauce demo
    Given The user is in Sauce demo
    When The user login
    Then The user is logged in

  Scenario: The user try to login with invalid credencials
    Given The user is in Sauce demo
    When The user try to login
    Then The user see a error message



