Feature: Book tours

@TS_04_1 @tours_book
Scenario: A user must be able to book tours on phptravels
	Given a user is on the landing page of phptravels and clicks tours
		When user selects city name, date and travellers on tours page
		And user clicks search button
		Then user verify title of the first found tours package