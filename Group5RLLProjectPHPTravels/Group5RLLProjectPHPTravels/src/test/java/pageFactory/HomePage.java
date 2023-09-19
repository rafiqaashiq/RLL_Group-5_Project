package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	JavascriptExecutor js;

	@FindBy(xpath = "//a[contains(text(),'Flights')]")
	static WebElement flightsTab;

	@FindBy(xpath = "(//a[contains(text(),'Hotels')])")
	static WebElement clickHotels;

	@FindBy(xpath = "//a[contains(text(),'Cars')]")
	private WebElement carTab;

	@FindBy(xpath = "//a[contains(text(),'Tours')]")
	static WebElement toursTab;

	@FindBy(xpath = "//a[contains(text(),'Blogs')]")
	static WebElement clickblogs;

	@FindBy(xpath = "//strong[contains(@class,'text-dark')]")
	private WebElement accountBtn;

	@FindBy(xpath = "//a[contains(text(),'Signup')]")
	private WebElement signInBtn;

	@FindBy(xpath = "(//button[contains(@type,'submit')])[6]")
	private WebElement firstCar;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	public void clickFlightsTab() {
		flightsTab.click();
	}

	public void Click_Tours() {
		toursTab.click();
	}

	public void clickOnCars() {
		carTab.click();
	}

	public void Click_Hotels() {
		js.executeScript("arguments[0].click()", clickHotels);
	}

	public void clickOnSignin() {
		accountBtn.click();
		signInBtn.click();
		js.executeScript("window.scrollBy(0, 150);");
	}

	public void clickFirstCar() {
		js.executeScript("arguments[0].scrollIntoView();", firstCar);
		js.executeScript("arguments[0].click()", firstCar);
	}

	public void ClickBlogs() {
		clickblogs.click();
	}
}
