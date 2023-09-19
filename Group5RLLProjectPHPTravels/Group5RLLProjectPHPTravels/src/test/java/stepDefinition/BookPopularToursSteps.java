package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadExcel;

public class BookPopularToursSteps extends Driver {

	@Given("a user is on the landing page of the PHP travels and clicks Tours")
	public void a_user_is_on_the_landing_page_of_the_php_travels_and_clicks_tours() {
		Assert.assertTrue(driver.getTitle().equals("PHPTRAVELS"));
		logger.info("The user is on landing page");
		homePage.Click_Tours();
		logger.info("The user navigates to tours page");
	}

	@When("user clicks on anyone of the popular tour available")
	public void user_clicks_on_anyone_of_the_popular_tour_available() {
		toursPage.Click_FirstTour();
	}

	@And("user selects date and traveller")
	public void user_selects_date_and_traveller() {
		searchResultPage.Click_Date();
	}

	@And("user clicks on book now")
	public void user_clicks_on_book_now() {
		searchResultPage.Click_Booknow();
	}

	@And("user enters details on tours booking page")
	public void user_enters_details_on_tours_booking_page() throws IOException {
		String[][] data = ReadExcel.getData("resources//EnterPersonalDetails.xlsx", "Sheet1");
		int row = 2;

		String fname = data[row][1];
		String lname = data[row][2];
		String email = data[row][3];
		String phno = data[row][4];
		String addr = data[row][5];

		bookingPage.enterPersonalDetails(fname, lname, email, phno, addr);
		bookingPage.Passenger1Details();
		bookingPage.Passenger2Details();
		logger.info("The user given all details");
	}

	@And("user clicks on the Confirm Booking button")
	public void user_clicks_on_the_confirm_booking_button() {
		bookingPage.paymentAndBooking();
	}

	@Then("user must be able to book a popular tours place")
	public void user_must_be_able_to_book_a_popular_tours_place() {
		paymentPage.confirmPaymentAndBooking();
		String expectedTotal = "Payment Test Credentials";
		String actualTotal = paymentPage.getVerificationText();
		Assert.assertEquals(actualTotal, expectedTotal);
		System.out.println(expectedTotal);
		System.out.println(actualTotal);
		logger.info("tours booking executed successfully");
	}
}
