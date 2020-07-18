Feature: Delete Users using DELETE Request

  @DeleteUser
  Scenario: Verify Deleting User
    Given I want to delete user id 2
    When I click delete user
    Then I should get a successful response with status code 204