@smoke
Feature: Create and bulk delete multiple action tokens

  @token
  Scenario Outline: User creates multiple action tokens
    Given User logs in to the application
    And User navigates to action token page
    And User creates an action token for put in "<tokenType>"

    Examples:
      |tokenType|
      |put in fleet|
      |put in repair|
      |put in stock|
      |reset device certificate|

  @bulkDelete
  Scenario: User performs bulk delete of all action tokens
    Given User logs in to the application
    And User navigates to action token page
    Then User performs bulk delete of all action tokens