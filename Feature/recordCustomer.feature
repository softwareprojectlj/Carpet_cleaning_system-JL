Feature: record new customer
  Scenario: customer recorded successfully
    Given that I Choose the new customer registration option
    When  I entered the correct information
    Then  the customer added successfully
    And   Send an acceptance email to the customer
