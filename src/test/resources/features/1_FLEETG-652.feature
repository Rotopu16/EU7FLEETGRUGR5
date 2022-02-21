Feature: Default

	Background:
		#@FLEETG-652
		
		    Given The user is on the Login page
		

	#*User Story :* 
	#
	#As a user, I should be able to log in
	#
	#*_Acceptance Criteria:_*
	#
	#{*}1{*}-All users can log in with valid credentials (We have 3 types of users such as sales manager, store manager, truck driver).
	#     - Driver should land on the "Quick Launchpad" page after successful login
	#     - Sales Manager/ Store Manager should land on the "Dashboard" page after successful login
	@FLEETG-651 @FLEETG-634
	Scenario Outline: Verify <userType> can log in with valid credentials
		Given User enters valid "<userType>" credentials
		    And User clicks on Login button
		    Then User should land on "<subPageTitle>" page
		
		    Examples:
		      | userType      | subPageTitle    |
		      | Driver        | Quick Launchpad |
		      | Store manager | Dashboard       |
		      | Sales manager | Dashboard       |	

	#*User Story :* 
	#
	#As a user, I should be able to log in
	#
	#*_Acceptance Criteria:_*
	#
	#{*}2{*}-"Invalid username or password." should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
	#
	#{*}3{*}- "Please fill out this field" message should be displayed if the password or username is empty
	@FLEETG-653 @FLEETG-634
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

	#*User Story :* 
	#
	#As a user, I should be able to log in
	#
	#*_Acceptance Criteria:_*
	#
	#{*}4{*}-User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
	@FLEETG-654 @FLEETG-634
	Scenario: Verify Forgot your password is working correctly
		When The user clicks "Forgot your password?" link
		    Then User lands on the "Forgot Password" page	

	#*User Story :* 
	#
	#As a user, I should be able to log in
	#
	#*_Acceptance Criteria:_*
	#
	#{*}5{*}-User can see "Remember Me" link exists and is clickable on the login page
	@FLEETG-655 @FLEETG-634
	Scenario: Verify Remember me link exists and working properly
		Then Remember Me link is visible
		    And Remember Me Check box is visible
		    When The user clicks Remember Me CheckBox
		    Then Remember Me Check Box is checked	

	#*User Story :* 
	#
	#As a user, I should be able to log in
	#
	#*_Acceptance Criteria:_*
	#
	#{*}6{*}-User should see the password in bullet signs by default
	@FLEETG-656 @FLEETG-634
	Scenario: Verify the User sees the password in bullet signs by default
		When User enters password credentials
		    Then The User sees the password in bullet signs by default	

	#*User Story :* 
	#
	#As a user, I should be able to log in
	#
	#*_Acceptance Criteria:_*
	#
	#{*}7{*}- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
	@FLEETG-657 @FLEETG-634
	Scenario: Verify if the Enter key of the keyboard is working correctly
		Given User enters valid "Driver" credentials
		    And User clicks on Enter key of the keybord
		    Then User should land on "Quick Launchpad" page	

	#*User Story :* 
	#
	#As a user, I should be able to log in
	#
	#*_Acceptance Criteria:_*
	#
	#*8-* All users can see their own usernames in the profile menu, after successful login
	#
	# 
	@FLEETG-658 @FLEETG-634
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