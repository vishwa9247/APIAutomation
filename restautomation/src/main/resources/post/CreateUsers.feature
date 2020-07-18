Feature: Create Users using POST Request

  @POSTScenario1
  Scenario: Verify Creating Users
    Given I want to create a user with name "Tom" AND job "QA"
    When I click create user
    Then I should get a successful response with status code 201
    And new user should have an id
    And user name should be "Tom" AND job should be "QA"
    And created date should be "today"