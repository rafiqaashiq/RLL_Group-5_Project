package pageFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToursPage {

	private WebDriverWait wait;

	JavascriptExecutor js;

	@FindBy(xpath = "(//span[contains(@class,'selection')])[1]")
	private WebElement Searchbyname;

	@FindBy(xpath = "(//div[contains(@class,'mx-2')])[1]")
	private WebElement Thailand;

	@FindBy(id = "date")
	private WebElement Date;

	@FindBy(xpath = "(//td[contains(@class,'day')])[35]")
	private WebElement Sel_Date;

	@FindBy(xpath = "(//div[contains(@class,'dropdown')])[1]")
	private WebElement Sel_Travellers;

	@FindBy(xpath = "(//div[contains(@class,'qtyInc')])[1]")
	private WebElement Count;

	@FindBy(xpath ="(//button[contains(@type,'submit')])[1]")
	private WebElement Btn_Search;

	@FindBy(xpath = "(//div[contains(@class,'position-absolute start-0 w-100')])[1]")
	private WebElement First_Tour;

	public ToursPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public void Click_Searchbyname() {
		Searchbyname.click();
		Thailand.click();
	}

	public void Click_Date() {
		Date.click();
		Sel_Date.click();
	}

	public void Click_Travellers() throws InterruptedException {
		Sel_Travellers.click();
		Count.click();
		Thread.sleep(2000);
	}

	public void Click_Search() {
		Btn_Search.click();
	}

	public void Click_FirstTour() {
		wait.until(ExpectedConditions.visibilityOf(First_Tour));
		js.executeScript("arguments[0].click()", First_Tour);
	}
}
