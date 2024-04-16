Feature: Zadanie1

  Scenario: Choose phone from the list
    Given Go to the TMobile page
    And Choose devices from the top bar
    And Choose no subscription from the smartwatches and bands
    And Click the first product on the list
    And Add the product to the cart
    When Go to the main TMobile page
    Then Main page is visible
    And There should be one element in the basket
