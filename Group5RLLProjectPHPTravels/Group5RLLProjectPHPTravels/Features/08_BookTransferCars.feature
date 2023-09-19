Feature: Book Transfer Cars

@TS_08
Scenario: A user must be able to book a transfer car on PHP Travels
	Given a user is on the landing page of PHP Travels
		When user clicks on the first car available
		And user enters details on carbooking page
		And user clicks on Confirm Booking button
		Then user must be able to book a transfer car