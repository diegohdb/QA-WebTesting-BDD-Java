Feature: Products

  Background:
    Given I open Lojinha
    And I insert the "TesterBDD" and "test"
    And I click on ENTRAR
    And I click on ADICIONAR PRODUTO

  Scenario: Add a product
    And I insert "Product1", "100", "black, white"
    When I click on SALVAR
    Then a toast shows the register confirmation and the product edition page is loaded


  Scenario: Add product without value
    Given I insert "Product2"
    When I click on SALVAR
    Then the product list is loaded and the "Product2" is not added

  Scenario: Delete a product
    Given I insert "ProductToDelete", "1000", "black, white"
    And I click on SALVAR
    And I go to products list
    When I delete the "ProductToDelete"
    Then a toast shows the delete confirmation and the "ProductToDelete" is not is seen in the product list

  Scenario: See product details
    Given I insert "ProductToDetails", "1000", "white"
    And I click on SALVAR
    And I go to products list
    When I click on the "ProductToDetails"
    Then the Edit product page is loaded with "ProductToDetails", "1000", and "white"