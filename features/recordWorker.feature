Feature: list of worker

  Background:
  |   Id  |      Name      |   Phone   |   Address    |     Status      |     Email       |
  |   1   | Sami Barakeh   | 0599786564|  Tulkarem    |    available    |sami@gmail.com   |
  |   2   | Ahmed Baraket  | 0598994532|   Bala'a     |  Not available  |ahmadB@gmail.com |
  |   3   |   Faud Ali     | 0599223344|   Anabta     |    available    |Faud.A@gmail.com |


  Scenario : The List of workers
    Given  the Worker not record
    When I entered the correct data
    Then the worker added Successfully

