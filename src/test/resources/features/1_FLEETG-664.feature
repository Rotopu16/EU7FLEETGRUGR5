@FLEETG-666 @Logout
Feature: Default

	Background:
		#@FLEETG-664
		
		Given The user is on the Login page
		

	#*User Story :* 
	#
	#As a user, I should be able to log out
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*1-* The user can log out and ends up on the login page.
	@FLEETG-663 @FLEETG-662
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

	#*User Story :* 
	#
	#As a user, I should be able to log out
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*2-* The user can not go to the home page again by clicking the step back button after successfully logging out.
	@FLEETG-665 @FLEETG-662
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

	#*User Story :* 
	#
	#As a user, I should be able to log out
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#{*}3{*}- The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
	@FLEETG-683 @FLEETG-662 @Logout
	Scenario: Verify the user is logged out in all tabs if the user logout on the current tab
		Given The user is logged in as "Driver"
		    And The user opens a new tab
		    When The user clicks on Profile Menu Dropdown
		    And The user clicks on Logout
		    Then User lands on the "Login" page
		    And The user closes the current tab
		    Then The user checks all other opened tabs are logged out