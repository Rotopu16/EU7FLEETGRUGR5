Feature: Logout Function

  Background:
    Given The user is on the Login page


  Scenario Outline: The <userType> can log out and ends up on the login page
    Given The user is logged in as "<userType>"
    And The user clicks on Profile Menu Dropdown
    And The user clicks on Logout
    Then User lands on the "Login" page
    Examples:
      | userType      |
      | Driver        |
      | Store manager |
      | Sales manager |


  Scenario Outline: The <userType> can not go to the home page again by clicking the step back button after successfully logging out.
    Given The user is logged in as "<userType>"
    And The user clicks on Profile Menu Dropdown
    And The user clicks on Logout
    When User lands on the "Login" page
    And User clicks navigate back arrow
    Then User lands on the "Login" page
    Examples:
      | userType      |
      | Driver        |
      | Store manager |
      | Sales manager |
  @wip
  Scenario: Verify the user is logged out in all tabs if the user logout on the current tab
    Given The user is logged in as "Driver"
    And The user opens a new tab
    When The user clicks on Profile Menu Dropdown
    And The user clicks on Logout
    Then User lands on the "Login" page
    And The user closes the current tab
    Then The user checks all other opened tabs are logged out