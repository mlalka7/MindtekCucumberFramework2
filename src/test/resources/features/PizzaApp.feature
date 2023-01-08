@regression @UI
Feature: Pizza application place order functionality

  @RTB-5
  Scenario Outline: Validating successful place order

    Given user navigates to "PizzaApp" application
    When user creates pizza order with data
      | Pizza    | <Pizza>    |
      | Topping1 | <Topping1> |
      | Topping2 | <Topping2> |
      | Quantity | <Quantity> |
      | Name     | <Name>     |
      | Email    | <Email>    |
      | Phone    | <Phone>    |
      | Payment  | <Payment>  |
    Then user validates that order is created with message "Thank you for your order! TOTAL: " "<Pizza>"

    Examples:
      | Pizza                        | Topping1  | Topping2     | Quantity | Name         | Email           | Phone      | Payment         |
      | Small 6 Slices - no toppings | Mushrooms | Extra cheese | 1        | Patel Harsh  | patel@gmail.com | 123456789  | Cash on Pickup  |
      | Large 10 Slices - 2 toppings | Olives    | Extra cheese | 2        | Sharon Stone | stone@gmail.com | 987654321  | Credit Card     |
      | Medium 8 Slices - 2 toppings | Salami    | Italian Ham  | 1        | Jay Leno     | leno@gmail.com  | 8564367932 | Cash on Payment |
