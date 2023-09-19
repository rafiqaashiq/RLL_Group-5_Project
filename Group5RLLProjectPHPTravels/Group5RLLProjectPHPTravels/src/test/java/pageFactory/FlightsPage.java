package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {

	JavascriptExecutor js;

	@FindBy(xpath = "(//div[contains(@class,'py-4')])[2]")
	static WebElement destination;

	@FindBy(xpath = "(//span[contains(@dir,'ltr')])[1]")
	static WebElement fromcitydropdown;

	@FindBy(xpath = "//strong[contains(text(),'Lahore')]")
	static WebElement firstcity;

	@FindBy(xpath = "(//span[contains(@dir,'ltr')])[2]")
	static WebElement tocitydropdown;

	@FindBy(xpath = "//strong[contains(text(),'Dubai')]")
	static WebElement tocity;

	@FindBy(id = "departure")
	static WebElement date;

	@FindBy(xpath = "(//td[contains(@class,'day')])[27]")
	static WebElement selectdate;

	@FindBy(xpath = "//a[contains(@data-toggle,'dropdown')]")
	static WebElement selectTravellers;

	@FindBy(xpath = "(//div[contains(@class,'qtyInc')])[1]")
	static WebElement selectadults;

	@FindBy(xpath = "//button[contains(@type,'submit')]")
	static WebElement searchbutton;

	public FlightsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	public void clickDestination() {
		js.executeScript("arguments[0].scrollIntoView();", destination);
		js.executeScript("arguments[0].click()", destination);
	}

	public void clickFirstcity() {
		fromcitydropdown.click();
		js.executeScript("arguments[0].click()", firstcity);
		tocitydropdown.click();
		js.executeScript("arguments[0].click()", tocity);
		date.click();
		js.executeScript("arguments[0].click()", selectdate);
		selectTravellers.click();
		js.executeScript("arguments[0].click()", selectadults);
		searchbutton.click();
	}
}
