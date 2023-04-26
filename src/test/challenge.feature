@Challenge
Feature: Challenge

  @Login
  Scenario: Login Success
    Given The user is login page
    When The user logs in
    Then The user is logged in

  @Login
  Scenario: Login Failure A
    Given The user is login page
    When The user enter wrong username and password
    Then The user see a error message

  @Login
  Scenario: Login Failure B
    Given The user is login page
    When The user leaves the user and password fields blank
    Then The user see a error message

  @Checkout
  Scenario: Checkout Form Order Success
    Given The user is checkout page
    When The user completes all the checkout fields
    When checkmark the checkbox same address
    When The user submit the form
    Then The user see that the order confirmation number is not empty


  @Checkout
  Scenario: Checkout Form Alert
    Given The user is checkout page
    When The user completes all the checkout fields
    When uncheckmark the checkbox same address
    When The user submit the form
    When The user accept the alert
    Then The user see that the alert is gone

  @Checkout
  Scenario: Cart Total Test
    Given The user is checkout page
    Then The user see cart total is correct

  @Grid
  Scenario: Grid Item Test
    Given The user is grid page
    Then The user see the position 7 is Super Pepperoni
    Then The user see the position 7 price is 10

  @Grid
  Scenario: Grid All Items Test
    Given The user is grid page
    Then The user sees all completed products

  @Search
  Scenario: Search Success
    Given The user is search page
    When The user search result for Automation
    Then The user sees the message for Automation results

  @Search
  Scenario: Search Empty
    Given The user is search page
    When The user presses search without entering any search criteria
    Then The user sees the message Please provide a search word