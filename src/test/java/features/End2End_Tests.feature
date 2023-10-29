Feature: Automated Amazon search End2End testing
  Description: end-to-end testing for Amazon search text box

  Scenario Outline: Customer place an order by purchasing an item from search
    Given User is on Home Page
    When Customer inputs "<productName>" in the SearchBox and Submit
    And select a product
    And moves to product details and click Add to Carts button
    Then the product "<productName>" is in the checklist


    Examples:
      | productName               | 
      | قلم |
	  | شنطة |