Feature: Updating Users using PUT Request

  @PUTScenario1
  Scenario: Verify Updating Users
    Given I want to update user id 2 name as "Tim" AND job as "DEV"
    When I click update user
    Then I should get a successful response with status code 200
    And user name should be "Tim" AND job should be "DEV"
    And updated date should be "today"