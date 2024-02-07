Feature: Get random activity
  get random activity when the person is bored

  Scenario: Get random activity
    Given user gets a random activity from bored API
    Then validate the response schema
    Then validate the response code


