package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadExcel;

public class BookFlightSteps extends Driver {

	@Given("a user is on the landing page of phptravels")
	public void a_user_is_on_the_landing_page_of_phptravels() {
		Assert.assertTrue(driver.getTitle().equals("PHPTRAVELS"));
		logger.info("Sucessfully reached home page");
	}

	@When("he clicks on Flights in the navigation bar")
	public void he_clicks_on_flights_in_the_navigation_bar() {
		homePage.clickFlightsTab();
		logger.info("Sucessfully reached flights tab");
	}

	@When("he select the From city as Lahore Pakistan to Delhi select date select travellers click search")
	public void he_select_the_from_city_as_lahore_pakistan_to_delhi_select_date_select_travellers_click_search() {
		flightsPage.clickFirstcity();
		logger.info("Sucessfully selected the country");
	}

	@When("he switches focus on the new tab clicks on Select Flight")
	public void he_switches_focus_on_the_new_tab_clicks_on_select_flight() {
		searchListPage.clickSelectFlight();
		logger.info("Sucessfully selected the flight");
	}

	@When("he switches focus on the new tab fills the details proceeds to booking")
	public void he_switches_focus_on_the_new_tab_fills_the_details_proceeds_to_confirm_booking() throws IOException {
		String[][] data = ReadExcel.getData("resources//EnterPersonalDetails.xlsx", "Sheet1");
		int row = 1;

		String fname = data[row][1];
		String lname = data[row][2];
		String email = data[row][3];
		String phno = data[row][4];
		String addr = data[row][5];

		bookingPage.enterPersonalDetails(fname, lname, email, phno, addr);
		bookingPage.enterPassenger1Details();
		bookingPage.enterPassenger1AddDetails();
		bookingPage.enterPassenger2Details();
		bookingPage.enterPassenger2AddDetails();
		bookingPage.paymentAndBooking();
		logger.info("Confirmed booking");
	}

	@Then("I should be directed to the booking confirmation page")
	public void i_should_be_directed_to_the_booking_confirmation_page() {
		paymentPage.confirmPaymentAndBooking();
		String expectedText = "Payment Test Credentials";
		String actualText = paymentPage.getVerificationText();
		Assert.assertEquals(actualText, expectedText);
		logger.info("Sucessfully verified");
	}
}
