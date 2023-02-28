Feature: Login
  Background:
  |sbarakeh15@gmail.com|123|

  Scenario: The Login process has been completed Successfull
    Given The user is not logged in
    And the password is "123"
    And the email is "sbarakeh15@gmail.com"
    Then the user login succeeds
    And the user is logged in



  Scenario: user have wrong email
    Given The user is not logged in
    And the email is "sbb@gmail.com"
    Then the user login fails
    And thw user is not logged in


  Scenario: user have wrong password
    Given The user is not logged in
    And the password is "1234"
    Then the user login fails
    And thw user is not logged in


