package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClickBlogsSteps extends Driver {

	@Given("a user is on landing page")
	public void a_user_is_on_landing_page() {
		logger.info("User LoginSucessfully");
	}

	@When("he clicks on Blogs in the navigator bar")
	public void he_clicks_on_blogs_in_the_navigator_bar() {
		homePage.ClickBlogs();
		logger.info("User Cliks the blogs Sucessfuly");
	}

	@When("he clicks on BlogsPage in the Blogs")
	public void he_clicks_on_blogs_page_in_the_blogs() {
		blogsPage.ClickPage();
		logger.info("User sucessfully cliks the BlogsPage");
	}

	@Then("he must be able to select the blogspage sucessfully.")
	public void he_must_be_able_to_select_the_blogspage_sucessfully() {
		Assert.assertTrue(driver.getTitle().equals("Where to Eat in Rome During Holidays"));
		logger.info("User verify the title Sucessfully");
	}
}
