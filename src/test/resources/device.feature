@smoke
Feature: Device Page test scenarios

  @device
  Scenario: Bulk export device page details
    Given User logs in to the application
    And User navigates to device page
    When User makes a bulk export of all devices
    Then User validates the cvs file contains the related datas

