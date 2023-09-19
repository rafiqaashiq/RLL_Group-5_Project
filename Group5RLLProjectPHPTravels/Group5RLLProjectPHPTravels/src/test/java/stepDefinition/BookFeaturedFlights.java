package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadExcel;

public class BookFeaturedFlights extends Driver {

	@Given("a user is on the homepage of PHPTravels")
	public void a_user_is_on_the_homepage_of_php_travels() {
		Assert.assertTrue(driver.getTitle().equals("PHPTRAVELS"));
		logger.info("User is on the Homepage of PHP Travels");
	}

	@When("he clicks on the Flights tab")
	public void he_clicks_on_the_flights_tab() {
		homePage.clickFlightsTab();
		logger.info("User has clicked the Flights tab in Homepage");
	}

	@When("he clicks on any one of the Featured destinations")
	public void he_clicks_on_any_one_of_the_featured_destinations() {
		flightsPage.clickDestination();
		logger.info("User has selected a Featured destination in Flights page");
	}

	@When("he clicks on any one of the listed Flights")
	public void he_clicks_on_any_one_of_the_listed_flights() {
		searchListPage.clickSelectFlight();
		logger.info("User has selected a Flight in Flights list page");
	}

	@When("he completes the Flight booking by entering passengers details")
	public void he_completes_the_flight_booking_by_entering_passengers_details() throws IOException {
		logger.info("User starts to fill the details required for Flight Booking");

		String[][] data = ReadExcel.getData("resources//EnterPersonalDetails.xlsx", "Sheet1");
		int row = 4;

		String fname = data[row][1];
		String lname = data[row][2];
		String email = data[row][3];
		String phno = data[row][4];
		String addr = data[row][5];

		bookingPage.enterPersonalDetails(fname, lname, email, phno, addr);
		bookingPage.enterPassenger1Details();
		bookingPage.enterPassenger1AddDetails();
		bookingPage.paymentAndBooking();
		logger.info("User has entered the details and confirmed the booking in Booking Page");
	}

	@Then("he confirms the booking by verifing the payment text")
	public void he_confirms_the_booking_by_verifing_the_payment_text() {
		paymentPage.confirmPaymentAndBooking();
		String expectedTxt = "Payment Test Credentials";
		String actualTxt = paymentPage.getVerificationText();
		Assert.assertEquals(actualTxt, expectedTxt);
		logger.info("User has completed the payment");
		logger.info("TEST SCRIPT RAN SUCCESSFULLY");
	}
}
