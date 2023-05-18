Feature: distributeorder
  Scenario: found available worker
    Given i have list of worker
    Then  i choose worker by id
    Then  check if this worker is avaliable

  Scenario: distribute worker
    Given i found available worker
    Then  distribute successful
    Then  put worker not available

  Scenario: complete order
    Given order complete
    Then  send email


