Feature: Track Order

  Scenario : how to track order
    Given The order is added now
    When there is a available worker
    Then the worker take the order
    When the delivery time comes
    Then the order done