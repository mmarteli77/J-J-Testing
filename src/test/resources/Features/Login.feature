Feature: test login functionality

@smoke
  Scenario Outline: check if login is sucessful with valid credencials
    Given the browser is open
    And user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navegated to the homepage

    Examples: 
      | username | password |
      | marcelo  |    12345 |
      | uliana   |    12345 |
      | matteus  |    12345 |
