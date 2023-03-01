Feature: add product
  each product should have a record in the system .
  Background:
  | Name    | ID    | height | width  |  recevdata      |  picture         |
  | carpet1 | 123   |  2.2   |    2   |  18/10/2022     |                  |
  | carpet2 | 456   |    4   |    2   |  14/02/2023     |                  |
  | carpet3 | 789   |    3   |   4.1  |  5/01/2023      |                  |

  Scenario: register product  when the customer is logged in
    Given that the user is logged in
    And their is a product with id "123" ,name "carpet1",height"2.2",width"2",recevdata "18/10/2022",picture"0595676822"
    When the product with id "123" register
    Then the product with id "123" ,name "carpet1",height"2.2",width"2",recevdata "18/10/2022",picture"0595676822" is registered in the system
  