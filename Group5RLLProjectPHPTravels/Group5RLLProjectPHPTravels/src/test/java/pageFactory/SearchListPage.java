package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchListPage {

	JavascriptExecutor js;

	@FindBy(xpath = "(//button[contains(text(),'Flight')])[2]")
	static WebElement selectFlightBtn;

	@FindBy(xpath = "(//button[contains(@type,'submit')])[6]")
	private WebElement firstCar;

	@FindBy(xpath = "(//div[contains(text(),'E Sim')])")
	private WebElement First_Search;

	@FindBy(xpath = "(//a[contains(text(),'Details')])[1]")
	private WebElement First_Result;

	public SearchListPage(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSelectFlight() {
		js.executeScript("arguments[0].scrollIntoView();", selectFlightBtn);
		js.executeScript("arguments[0].click()", selectFlightBtn);
	}

	public void clickFirstCar() {
		js.executeScript("arguments[0].scrollIntoView();", firstCar);
		js.executeScript("arguments[0].click()", firstCar);
	}

	public String getMsg() {
		String message = First_Search.getText();
		return message;
	}

	public void Click_FirstResult() {
		First_Result.click();
	}
}
