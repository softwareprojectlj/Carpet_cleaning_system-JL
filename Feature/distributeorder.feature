Feature: distribute order

  Scenario : how to distribute order
    Given add new producet
    When distribute in the available worker
    When the delivery time comes
    Then complete the order