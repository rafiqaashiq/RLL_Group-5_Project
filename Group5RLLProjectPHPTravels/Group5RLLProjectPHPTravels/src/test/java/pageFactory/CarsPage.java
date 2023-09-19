package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarsPage {

	JavascriptExecutor js;

	@FindBy(xpath = "(//span[contains(@class,'selection')])[1]")
	private WebElement Searchbyname;

	@FindBy(xpath = "(//div[contains(@class,'d-flex')])[25]")
	private WebElement Thailand;

	@FindBy(xpath = "//button[contains(@type ,'submit')]")
	private WebElement SearchBtn;

	public CarsPage(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void DropDown() {
		Searchbyname.click();
		Thailand.click();
	}

	public void Search() {
		SearchBtn.click();
	}
}
