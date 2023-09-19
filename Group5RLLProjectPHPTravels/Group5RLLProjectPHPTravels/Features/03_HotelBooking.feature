Feature: Hotel Booking

@TS_03
Scenario: Book the Hotel Room
	Given A user is on the landing page of phptravels
		And he clicks best Hotels on the City from Dropdown
		And he selects the Checkin and Checkout date
		And he select no of Travellers and click search
		Then he selects some Hotel
		And he selects the room
		And he completes the booking process and verifies