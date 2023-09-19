Feature: To book a Flight via Featured Flights

@TS_07
Scenario: A user must be able to book a flight on PHPTravels
	Given a user is on the homepage of PHPTravels
		When he clicks on the Flights tab
		And he clicks on any one of the Featured destinations
		And he clicks on any one of the listed Flights
		And he completes the Flight booking by entering passengers details
		Then he confirms the booking by verifing the payment text