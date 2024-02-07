Feature: Create Course
  create course at winjigo website.

  Background:
    Given user opens winjigo website

  Scenario: Create course
    Given user logins to winjigo website using valid username and password
    When user opens courses page from left side navigation bar
    And user clicks on Add Course button
    And user fill course details and add it
    Then user validate that the created course title appears in the courses page
    Then user close the browser


