Feature: print invoice
  Scenario: print invoice successful
    Given i entered id of product
    Then  Calculate the price
    Then  print the invoice

  Scenario: Total paid successful
    Given print total paid

