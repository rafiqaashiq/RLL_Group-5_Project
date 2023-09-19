package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	JavascriptExecutor js;

	@FindBy(xpath = "(//small[@class='d-block'])[2]")
	private WebElement BookNow;

	@FindBy(name = "date")
	private WebElement Date;

	@FindBy(xpath = "(//td[contains(@class,'day')])[35]")
	private WebElement Sel_Date;

	@FindBy(xpath = "//div[contains(@class,'btn-box pt-2')]")
	private WebElement Btn_Booknow;

	public SearchResultPage(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void Click_Book() {
		js.executeScript("arguments[0].click()", BookNow);
	}

	public void Click_Date() {
		Date.click();
		Sel_Date.click();
	}

	public void Click_Booknow() {
		Btn_Booknow.click();
	}
}
