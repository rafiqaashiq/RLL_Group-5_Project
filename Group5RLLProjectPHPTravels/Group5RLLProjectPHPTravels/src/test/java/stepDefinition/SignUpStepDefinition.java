package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.util.UUID;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDefinition extends Driver {
	UUID uuid = UUID.randomUUID();
	
	@Given("the user navigates to the registration page")
	public void the_user_navigates_to_the_registration_page() {
		homePage.clickOnSignin();
		logger.info("SignUp Clicked SucessFully");
	}

	@When("the user provides their first name as {string}")
	public void the_user_provides_their_first_name_as(String string) {
		signupPage.enterFirstName("Kl");
		logger.info("Entered FirstName");
	}

	@When("the user provides their last name as {string}")
	public void the_user_provides_their_last_name_as(String string) {
		signupPage.enterLastName("Rahul");
		logger.info("Entered LastName");
	}

	@When("the user selects their country as {string}")
	public void the_user_selects_their_country_as(String string) {
		signupPage.clickOnCountry();
		signupPage.enterCountryName("india");
		signupPage.enterPhoneNumber("987654323456");
		logger.info("Selected CountryName FromDropDown");
	}

	@When("the user enters their email as {string}")
	public void the_user_enters_their_email_as(String string) {
		signupPage.enterEmail(uuid + "@gmail.com");
		logger.info("Entered Email");
	}

	@When("the user sets their password as {string}")
	public void the_user_sets_their_password_as(String string) {
		signupPage.enterPassword("P@ssw0rd");
		logger.info("Entered password ");
	}

	@When("the user agrees to the terms and conditions")
	public void the_user_agrees_to_the_terms_and_conditions() throws InterruptedException {
		signupPage.switchToRecaptchaFrame();
		signupPage.checkCheckBox();
		logger.info("UserChecking check box i am not a robot");
	}

	@When("the user completes the registration process")
	public void the_user_completes_the_registration_process() {
		signupPage.ClickOnSignUpBtn();
		logger.info("Clicked on SignUp Btn");
	}

	@Then("the user should receive a unique confirmation code via email")
	public void the_user_should_receive_a_unique_confirmation_code_via_email() {
		assertTrue(driver.getTitle().equals("Signup Success"));
		logger.info("User Sees welcome message");
	}
}