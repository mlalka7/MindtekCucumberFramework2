@regression @smoke @ui
Feature: Validating order creation functionalities

  @RTB-4
    #before
  Scenario Outline: Validating order calculation functionality
    Given user navigates to "WebOrders" application
    When user enters username "Tester" and password "test" and clicks on login button
    And user clicks on Order module
    And user selects "<product>" with <quantity>
    Then user validates total is calculated properly for <quantity>
    #after
    Examples:
      | product     | quantity |
      | MyMoney     | 10       |
      | FamilyAlbum | 55       |
      | ScreenSaver | 3        |

  @RTB-6
  Scenario: Validating create order functionality
    Given user navigates to "WebOrders" application
    When user enters username "Tester" and password "test" and clicks on login button
    And user clicks on Order module
    And user creates order with data
      | product     | MyMoney          |
      | quantity    | 10               |
      | name        | John Doe         |
      | street      | 123 MyRoad       |
      | city        | Chicago          |
      | state       | IL               |
      | zip         | 60622            |
      | cc          | 1234123412341234 |
      | expire date | 07/25            |
    Then user validates success message "New order has been successfully added."