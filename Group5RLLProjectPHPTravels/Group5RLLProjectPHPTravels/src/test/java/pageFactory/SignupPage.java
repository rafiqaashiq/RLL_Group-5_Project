package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(xpath = "//div[contains(@class,'filter-option-inner-inner')]")
	private WebElement selectCountry;

	@FindBy(xpath = "(//input[contains(@class,'form-control')])[3]")
	private WebElement searchCountryTxtBox;

	@FindBy(id = "bs-select-1-99")
	private WebElement searchCountryName;

	@FindBy(id = "phone")
	private WebElement phoneNumber;

	@FindBy(id = "user_email")
	private WebElement emailTxtBox;

	@FindBy(id = "password")
	private WebElement paswordTxtBox;

	@FindBy(xpath = "//iframe[contains(@title,'reCAPTCHA')]")
	private WebElement recaptchaFrame;

	@FindBy(xpath = "(//div[contains(@class,'recaptcha-checkbox-border')])[1]")
	private WebElement checkBox;

	@FindBy(id = "submitBTN")
	private WebElement signUpBtn;

	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void clickOnCountry() {
		selectCountry.click();
	}

	public void enterCountryName(String country) {
		searchCountryTxtBox.sendKeys(country);
		searchCountryName.click();
	}

	public void enterPhoneNumber(String phone) {
		phoneNumber.sendKeys(phone);
	}

	public void enterEmail(String email) {
		emailTxtBox.sendKeys(email);
	}

	public void enterPassword(String password) {
		paswordTxtBox.sendKeys(password);
	}

	public void switchToRecaptchaFrame() {
		driver.switchTo().frame(recaptchaFrame);
	}

	public void checkCheckBox() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
	}

	public void ClickOnSignUpBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
	}
}
