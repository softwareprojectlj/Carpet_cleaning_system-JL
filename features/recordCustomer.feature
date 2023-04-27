Feature: record new customer
  Scenario: customer recorded successfully
    Given the customer not recorded
    When  I entered the correct data
    Then  the customer added
