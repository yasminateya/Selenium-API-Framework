Feature: User registration
  I want to check that the user can register in automation practice web

  Scenario Outline: User registration
    Given the user is on the home page
    When I click on the sign in link
    And I entered "<mail>"
    Then The registration page is displayed

    Examples:
    |mail|
    |yasmin@test.com|
    |yasminateya@test.com|