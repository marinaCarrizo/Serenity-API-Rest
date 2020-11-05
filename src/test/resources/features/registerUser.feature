Feature: Automate Register and Login APIs

  Scenario: Register user for https://restful-booker.herokuapp.com
    Given the user has the credentials
    |username|password|
    |admin   |password123|
    When the user sents a POST request to register API with valid request
    Then register API should have status code as 200
    And content-type as JSON
    And the register API should return proper json response "token"
