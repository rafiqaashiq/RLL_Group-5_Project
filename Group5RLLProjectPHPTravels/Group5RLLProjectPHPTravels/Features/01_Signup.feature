Feature: User Registration

@TS_01
Scenario: User signs up with valid information and receives a unique confirmation code
	Given the user navigates to the registration page
		When the user provides their first name as "Kl"
		And the user provides their last name as "Rahul"
		And the user selects their country as "India"
		And the user enters their email as "UUID"
		And the user sets their password as "abc123"
		And the user agrees to the terms and conditions
		And the user completes the registration process
		Then the user should receive a unique confirmation code via email