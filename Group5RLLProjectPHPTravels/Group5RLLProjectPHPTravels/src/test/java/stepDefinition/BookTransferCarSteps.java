package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadExcel;

public class BookTransferCarSteps extends Driver {

	@Given("a user is on the landing page of PHP Travels")
	public void a_user_is_on_the_landing_page_of_php_travels() {
		Assert.assertTrue(driver.getTitle().equals("PHPTRAVELS"));
		logger.info("User is on landing Page of PHPTravels");
	}

	@When("user clicks on the first car available")
	public void user_clicks_on_the_first_car_available() {
		homePage.clickFirstCar();
		logger.info("User click's on transfer cars in PHPTravels");
	}

	@When("user enters details on carbooking page")
	public void user_enters_details_on_carbooking_page() throws IOException {
		String[][] data = ReadExcel.getData("resources//EnterPersonalDetails.xlsx", "Sheet1");
		int row = 5;

		String fname = data[row][1];
		String lname = data[row][2];
		String email = data[row][3];
		String phno = data[row][4];
		String addr = data[row][5];

		bookingPage.enterPersonalDetails(fname, lname, email, phno, addr);
		bookingPage.Passenger1Details();
		bookingPage.Passenger2Details();
		logger.info("User completed entering details");
	}

	@When("user clicks on Confirm Booking button")
	public void user_clicks_on_confirm_booking_button() {
		bookingPage.paymentAndBooking();
		logger.info("User is on Booking Page of PHPTravels");
	}

	@Then("user must be able to book a transfer car")
	public void user_must_be_able_to_book_a_transfer_car() {
		paymentPage.confirmPaymentAndBooking();
		String expectedTxt = "Payment Test Credentials";
		String actualTxt = paymentPage.getVerificationText();
		Assert.assertEquals(actualTxt, expectedTxt);
		logger.info("User is on Payment Page of PHPTravels");
	}
}
