Feature: Add invoice to a system
  Background:
  |Customer name  |carpet name | address                | price | Date        |
  |     jana      |  carpet1   | Tulkarem_barakeh street| 30    | 10/10/2022  |
  |    lemara     |  carpet2   | Anabta_roman street    |  70   | 06/01/2023  |
  Scenario: add a invoice successfully
    Given that the admin is logged in
    Given there is a invoice with "<Customer name>" ,"<carpet name>" ,"<address>","<price>" ,"<Date>"
    When the invoice is added in the system
    Then the invoice with "<Customer name>" ,"<carpet name>" ,"<address>","<price>" ,"<Date>" is contained in the system


