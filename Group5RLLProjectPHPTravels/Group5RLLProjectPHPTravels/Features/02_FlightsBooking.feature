Feature: Book Flights

@TS_02
Scenario: A user must be  able to book a flight on phptravels
	Given a user is on the landing page of phptravels
		When he clicks on Flights in the navigation bar
		And he select the From city as Lahore Pakistan to Delhi select date select travellers click search
		And he switches focus on the new tab clicks on Select Flight
		And he switches focus on the new tab fills the details proceeds to booking
		Then I should be directed to the booking confirmation page