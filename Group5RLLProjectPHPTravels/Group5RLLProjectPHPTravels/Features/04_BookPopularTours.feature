Feature: Book tours2

@TS_04_2 @tours_book2
Scenario: A user must be able to book popular tours  on phptravels
	Given a user is on the landing page of the PHP travels and clicks Tours
		When user clicks on anyone of the popular tour available
		And user selects date and traveller
		And user clicks on book now
		And user enters details on tours booking page
		And user clicks on the Confirm Booking button
		Then user must be able to book a popular tours place