Feature:kano code challenge

  Scenario: Add computer kit bundle to basket
    Given the user is in the kano home page
    When user selects a Computer Kit Bundle
    And user is in the product's page
    And user decides to buy a Computer Kit Bundle
    Then user is in the cart page
    And the Computer Kit Bundle should be added in the basket.


  Scenario: Change to another country, Add a computer kit bundle
    Given the user is in the kano home page
    When user decides to change the country to US
    And  user confirms the country
    Then US displays in the country selection
    When user selects a Computer Kit Bundle
    And user is in the product's page
    Then the currency is shown in USD
    And user decides to buy a Computer Kit Bundle
    Then user is in the cart page
    And the Computer Kit Bundle should be added in the basket.
    And the currency should be in USD

    Scenario: Check the menu and the footer
      Given the user is in the kano home page
      Then user expected to view the menu items
      |World|
      |Make |
      |Shop |
      |Educators|
      |Blog|
      When user click Make from menu
      Then user is in kano's project page
      And user views Connected Kanos in footer
      And user views Lines of code in footer
      And user views Creations in footer










