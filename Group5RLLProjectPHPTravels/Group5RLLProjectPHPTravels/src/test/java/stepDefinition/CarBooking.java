package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadExcel;

public class CarBooking extends Driver {
	@Given("a user is on landing page of the PHP Travels")
	public void a_user_is_on_landing_page_of_the_php_travels() {
		Assert.assertTrue(driver.getTitle().equals("PHPTRAVELS"));
		logger.info("User is on landing Page of PHPTravels");
	}

	@When("user clicks on first of the car available")
	public void user_clicks_on_first_of_the_car_available() {
		homePage.clickOnCars();
		carsPage.DropDown();
		carsPage.Search();
		searchListPage.clickFirstCar();
	}

	@When("user enters details on the car booking page")
	public void user_enters_details_on_the_car_booking_page() throws IOException {
		String[][] data = ReadExcel.getData("resources//EnterPersonalDetails.xlsx", "Sheet1");
		int row = 3;

		String fname = data[row][1];
		String lname = data[row][2];
		String email = data[row][3];
		String phno = data[row][4];
		String addr = data[row][5];

		bookingPage.enterPersonalDetails(fname, lname, email, phno, addr);
		bookingPage.Passenger1Details();
	}

	@When("user clicks the Confirm Booking button")
	public void user_clicks_the_confirm_booking_button() {
		bookingPage.paymentAndBooking();
	}

	@Then("user must be able to book a car")
	public void user_must_be_able_to_book_a_car() {
		paymentPage.confirmPaymentAndBooking();
		String expectedTxt = "Payment Test Credentials";
		String actualTxt = paymentPage.getVerificationText();
		Assert.assertEquals(actualTxt, expectedTxt);
		logger.info("User is on Payment Page of PHPTravels");
	}
}
