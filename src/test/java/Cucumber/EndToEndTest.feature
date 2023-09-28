Feature: Purchasze the order from Ecommerce Website
  I want to use this templeate for my feature file

  Background:
    Given  I landed on Ecommerce page

  Scenario Outline:  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page

    Examples:
      | name                 | password |        productName|
      | kellycc677@gmail.com | 123456   |       ADIDAS ORIGINAL |
