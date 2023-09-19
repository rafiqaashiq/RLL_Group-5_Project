package stepDefinition;

import org.openqa.selenium.chrome.ChromeDriver;

import listeners.Tools;
import pageFactory.BlogsPage;
import pageFactory.BookingPage;
import pageFactory.CarsPage;
import pageFactory.FlightsPage;
import pageFactory.HomePage;
import pageFactory.HotelsPage;
import pageFactory.PaymentPage;
import pageFactory.SearchListPage;
import pageFactory.SearchResultPage;
import pageFactory.SignupPage;
import pageFactory.ToursPage;

public class Driver extends Tools {

	protected static HomePage homePage;
	protected static FlightsPage flightsPage;
	protected static HotelsPage hotelsPage;
	protected static CarsPage carsPage;
	protected static ToursPage toursPage;
	protected static BlogsPage blogsPage;
	protected static SearchListPage searchListPage;
	protected static SearchResultPage searchResultPage;
	protected static SignupPage signupPage;
	protected static BookingPage bookingPage;
	protected static PaymentPage paymentPage;

	public static void init() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.net/");

		homePage = new HomePage(driver);
		flightsPage = new FlightsPage(driver);
		hotelsPage = new HotelsPage(driver);
		carsPage = new CarsPage(driver);
		toursPage = new ToursPage(driver);
		blogsPage = new BlogsPage(driver);
		searchListPage = new SearchListPage(driver);
		searchResultPage = new SearchResultPage(driver);
		signupPage = new SignupPage(driver);
		bookingPage = new BookingPage(driver);
		paymentPage = new PaymentPage(driver);
	}
}
