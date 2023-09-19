package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Php_HotelTest extends Driver {

	@Given("A user is on the landing page of phptravels")
	public void a_user_is_on_the_landing_page_of_phptravels() {
		Assert.assertTrue(driver.getTitle().equals("PHPTRAVELS"));
		homePage.Click_Hotels();
		
	}

	@Given("he clicks best Hotels on the City from Dropdown")
	public void he_clicks_best_hotels_on_the_city_from_dropdown() {
		hotelsPage.Click_Searchbyname();
	}

	@Then("he selects the Checkin and Checkout date")
	public void he_selects_the_checkin_and_checkout_date() {
		hotelsPage.Click_Date();
	}

	@Then("he select no of Travellers and click search")
	public void he_select_no_of_travellers_and_click_search() throws InterruptedException {
		hotelsPage.Click_Travellers();
		hotelsPage.Click_Search();
	}

	@Then("he selects some Hotel")
	public void he_selects_some_hotel() {
		searchListPage.Click_FirstResult();
	}

	@Then("he selects the room")
	public void he_selects_the_room() {
		searchResultPage.Click_Book();
	}

	@Then("he completes the booking process and verifies")
	public void he_completes_the_booking_process_ande_verifies() {
		bookingPage.PersonalDetails();
		bookingPage.paymentAndBooking();
		String expectedTxt = "Payment Test Credentials";
		String actualTxt = paymentPage.getVerificationText();
		Assert.assertEquals(actualTxt, expectedTxt);
		logger.info("User is on Payment Page of PHPTravels");
	}
}
