Feature: Book Transfer Cars

@TS_05
Scenario: A user must be able to book a transfer car on the PHP Travels
	Given a user is on landing page of the PHP Travels
		When user clicks on first of the car available
		And user enters details on the car booking page
		And user clicks the Confirm Booking button
		Then user must be able to book a car