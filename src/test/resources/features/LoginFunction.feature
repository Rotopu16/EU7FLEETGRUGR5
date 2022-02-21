@login
Feature: Login Function

  Background:
    Given The user is on the Login page

  Scenario Outline: Verify <userType> can log in with valid credentials

    Given User enters valid "<userType>" credentials
    And User clicks on Login button
    Then User should land on "<subPageTitle>" page

    Examples:
      | userType      | subPageTitle    |
      | Driver        | Quick Launchpad |
      | Store manager | Dashboard       |
      | Sales manager | Dashboard       |


  Scenario Outline: Verify Users can`t log in with invalid credentials

    Given User enters invalid or empty "<username>" and "<password>"
    And User clicks on Login button
    Then User should see "<message>"

    Examples:
      | username | password    | message                        |
      | user1    |             | Please fill out this field.    |
      |          | UserUser123 | Please fill out this field.    |
      | user1    | abc         | Invalid user name or password. |
      | abc      | UserUser123 | Invalid user name or password. |


  Scenario: Verify Forgot your password is working correctly
    When The user clicks "Forgot your password?" link
    Then User lands on the "Forgot Password" page


  Scenario: Verify Remember me link exists and working properly
    Then Remember Me link is visible
    And Remember Me Check box is visible
    When The user clicks Remember Me CheckBox
    Then Remember Me Check Box is checked

  Scenario: Verify the User sees the password in bullet signs by default
    When User enters password credentials
    Then The User sees the password in bullet signs by default


  Scenario: Verify if the Enter key of the keyboard is working correctly
    Given User enters valid "Driver" credentials
    And User clicks on Enter key of the keybord
    Then User should land on "Quick Launchpad" page


  Scenario Outline: Verify all users can see their own usernames in the profile menu, after successful login

    Given User enters valid "<userType>" credentials
    And User clicks on Login button
    Then User should land on "<subPageTitle>" page
    And The "<userType>"s can see their own usernames in the profile menu

    Examples:
      | userType      | subPageTitle    |
      | Driver        | Quick Launchpad |
      | Store manager | Dashboard       |
      | Sales manager | Dashboard       |
