Feature: Login

  Background:
    Given I open Lojinha

  Scenario: Valid Login
    When I insert the "TesterBDD" and "test"
    And I click on ENTRAR
    Then the user is granteed to the website


  Scenario: Invalid Login
    When I insert the "TesterBDD" and "wrong"
    And I click on ENTRAR
    Then the user is not allowed to login the website