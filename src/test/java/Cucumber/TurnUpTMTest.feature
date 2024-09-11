Feature: Material And Time CRUD functionality testing

  Background:
    Given user login the system with valid credentials

  Scenario: Create a new record with valid information
    Given I navigate to the Time and Material page
    When I click the createNew button and enter the information and save
      | typeCode | code        | description | price |
      | T        | T2024082207 | T20240822   | $30   |
    Then a new record should be created successfully
      | record    |
      | T2024082207 |

  Scenario:Edit an existing time record with valid data
    Given  I navigate to the Time and Material page
    When I update the information on an existing record
    Then the record should have the updated information

  Scenario: Delete an existing record
     Given  I navigate to the Time and Material page
     When I delete an existing record
     Then the record should not be present on the table
