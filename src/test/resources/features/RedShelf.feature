@regression @ui @RTB-7
Feature: Validating RedShelf application search and filter functionalities

  Background: Repeat first step in each scenario
    Given user navigates to "RedShelf" application

  @RTB-7
  Scenario: Some scenario
    When user searches "Purple Cow" book
    And user choose first book in search result
    And user clicks on Add To Cart button
    Then user clicks on view cart button and validates book is in cart

  @RTB-8
  Scenario: Second scenario
    When user searches "Java data structure" book
    Then user validates first result page having no more than 25 books.

  @RTB-9
  Scenario: validating "Your Cart is Empty" message
    When user searches "Purple Cow" book
    And user choose first book in search result
    And user click on Add To Cart button
    And user clicks on empty cart button
    Then user validates “Your Cart is Empty“ message

  @RTB-10
  Scenario:validating book search by ISBN number
    When user searches “Purple Cow” book
    And user clicks on purple cow book and stores ISBN number
    And user search for a book with stored ISBN number
    Then user validates that search result has “Purple cow“ book
