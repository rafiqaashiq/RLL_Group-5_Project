package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookToursSteps extends Driver {

	@Given("a user is on the landing page of phptravels and clicks tours")
	public void a_user_is_on_the_landing_page_of_phptravels() {
		Assert.assertTrue(driver.getTitle().equals("PHPTRAVELS"));
		logger.info("The user is on landing page");
		homePage.Click_Tours();
	}

	@When("user selects city name, date and travellers on tours page")
	public void he_selects_city_name_date_and_travellers_on_tours_page() throws InterruptedException {
		toursPage.Click_Searchbyname();
		toursPage.Click_Date();
		toursPage.Click_Travellers();
	}

	@And("user clicks search button")
	public void he_click_search_button() {
		toursPage.Click_Search();
	}

	@Then("user verify title of the first found tours package")
	public void he_verify_title_of_the_first_found_tours_package() {
		String expectedMsg = "E Sim Thailand Unlimited";
		String actualMsg = searchListPage.getMsg();
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		logger.info("The user verifies first found tour page");
	}
}
