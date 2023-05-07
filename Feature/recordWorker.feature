Feature: list of worker

  Scenario: worker recorded successfully
    Given that I Choose the new worker registration option
    When  I entered the correct information
    Then  the worker added successfully
    And   Send an acceptance email to the worker
