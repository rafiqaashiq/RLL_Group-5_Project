package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {

	JavascriptExecutor js;

	@FindBy(id = "select2-hotels_city-container")
	private WebElement Searchbyname;

	@FindBy(xpath = "(//div[@class='mx-2'])[1]")
	private WebElement Dubai;

	@FindBy(id = "checkin")
	private WebElement Checkin;

	@FindBy(xpath = "(//td[contains(@class,'day')])[34]")
	private WebElement Checkin2;

	@FindBy(id = "checkout")
	private WebElement Checkout;

	@FindBy(xpath = "(//td[contains(@class,'day')])[83]")
	private WebElement Checkout2;

	@FindBy(xpath = "(//div[contains(@class,'dropdown')])[1]")
	private WebElement Travellers;

	@FindBy(id = "nationality")
	private WebElement nation;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SearchBtn;

	public HotelsPage(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void Click_Searchbyname() {
		Searchbyname.click();
		Dubai.click();
	}

	public void Click_Date() {
		Checkin.click();
		Checkin2.click();
		Checkout2.click();
	}

	public void Click_Travellers() throws InterruptedException {
		Travellers.click();
		Thread.sleep(1000);
		nation.sendKeys("India");
	}

	public void Click_Search() {
		SearchBtn.click();
	}
}
