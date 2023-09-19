package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	JavascriptExecutor js;

	@FindBy(id = "form")
	static WebElement proceedBtn;

	@FindBy(xpath = "//strong[contains(text(),'Payment')]")
	static WebElement verificationText;

	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	public void confirmPaymentAndBooking() {
		proceedBtn.click();
	}

	public String getVerificationText() {
		String text = verificationText.getText();
		return text;
	}
}
