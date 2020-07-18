Feature: Search Users using GET Request

  @Scenario1 @getScenario
  Scenario: Verify Searching All Users
    Given I want to search for all users
    When I click search all users
    Then I should get a successful response with status code 200
    And page number should be 1
    And per page should be 6
    And total users should be 12
    And total pages should be 2
    And response should return 6 users
    And users should have an id
    And user id 1 first name should be "George" AND last name should be "Bluth"
    And user id 2 first name should be "Janet" AND last name should be "Weaver"
    And user id 3 first name should be "Emma" AND last name should be "Wong"
    And user id 4 first name should be "Eve" AND last name should be "Holt"
    And user id 5 first name should be "Charles" AND last name should be "Morris"
    And user id 6 first name should be "Tracey" AND last name should be "Ramos"

  @Scenario2 @getScenario
  Scenario: Verify Searching Users in Page 2
    Given I want to search for users in page
    When I click search users in the page
    Then I should get a successful response with status code 200
    And page number should be 2
    And per page should be 6
    And total users should be 12
    And total pages should be 2
    And response should return 6 users
    And users should have an id
    And user id 7 first name should be "Michael" AND last name should be "Lawson"
    And user id 8 first name should be "Lindsay" AND last name should be "Ferguson"
    And user id 9 first name should be "Tobias" AND last name should be "Funke"
    And user id 10 first name should be "Byron" AND last name should be "Fields"
    And user id 11 first name should be "George" AND last name should be "Edwards"
    And user id 12 first name should be "Rachel" AND last name should be "Howell"

  @Scenario3
  Scenario: Verify Searching Users by ID
    Given I want to search for user id 2
    When I click search user
    Then I should get a successful response with status code 200
    And user should have an id
    And user first name should be "Janet" AND last name should be "Weaver"
