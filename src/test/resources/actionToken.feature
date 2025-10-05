@smoke
Feature: Create and bulk delete multiple action tokens

  @device
  Scenario: User creates multiple action tokens and perform bulk delete
    Given User logs in to the application
    And User navigates to action token page
    And User creates an action token for put in fleet
    And User creates an action token for put in repair
    And User creates an action token for put in stock
    And User creates an action token for reset device certificate
    Then User performs bulk delete of all action tokens