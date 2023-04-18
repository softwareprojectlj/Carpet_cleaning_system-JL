Feature: Login
  Background:
  |Email               |password |
  |sbarakeh15@gmail.com|  123    |

  Scenario: The Login process has been completed Successful
    Given The user is not logged in
    And the password is "<password>"
    And the email is "<Email>"
    Then the user login succeeds
    And the user is logged in



  Scenario: user have wrong email
    Given The user is not logged in
    And the email is "<Email>"
    Then the user login fails
    And the user is not logged in


  Scenario: user have wrong password
    Given The user is not logged in
    And the password is "<password>"
    Then the user login fails
    And the user is not logged in


