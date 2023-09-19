package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {

	JavascriptExecutor js;

	@FindBy(name = "user[first_name]")
	static WebElement fNameBox;

	@FindBy(name = "user[last_name]")
	static WebElement lNameBox;

	@FindBy(name = "user[email]")
	static WebElement emailBox;

	@FindBy(name = "user[phone]")
	static WebElement pNoBox;

	@FindBy(name = "user[address]")
	static WebElement addressBox;

	@FindBy(xpath = "(//button[contains(@type,'button')])[2]")
	static WebElement nationality;

	@FindBy(xpath = "(//input[contains(@type,'search')])[1]")
	static WebElement nationalitySBox;

	@FindBy(xpath = "(//a[contains(@class,'active')])[2]")
	static WebElement selectNationality;

	@FindBy(xpath = "(//button[contains(@type,'button')])[3]")
	static WebElement currentCountry;

	@FindBy(xpath = "(//input[contains(@type,'search')])[2]")
	static WebElement countrySBox;

	@FindBy(xpath = "(//a[contains(@class,'active')])[3]")
	static WebElement selectCurrentCountry;

	@FindBy(name = "first_name_1")
	static WebElement passenger1FName;

	@FindBy(name = "firstname_1")
	static WebElement passengerFName1;

	@FindBy(name = "last_name_1")
	static WebElement passenger1LName;

	@FindBy(name = "lastname_1")
	static WebElement passengerLName1;

	@FindBy(name = "nationality_1")
	static WebElement passenger1Nationality;

	@FindBy(name = "passport_1")
	static WebElement passport1;

	@FindBy(name = "first_name_2")
	private WebElement passenger2FName;

	@FindBy(name = "last_name_2")
	private WebElement passenger2LName;

	@FindBy(name = "firstname_2")
	static WebElement passengerFName2;

	@FindBy(name = "lastname_2")
	static WebElement passengerLName2;

	@FindBy(name = "nationality_2")
	private WebElement passenger2Nationality;

	@FindBy(name = "passport_2")
	private WebElement passport2;

	@FindBy(id = "agreechb")
	static WebElement checkBox;

	@FindBy(id = "booking")
	static WebElement confirmBooking;

	public BookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	public void PersonalDetails() {
		fNameBox.sendKeys("John");
		lNameBox.sendKeys("Doe");
		emailBox.sendKeys("JohnDoe@gmail.com");
		pNoBox.sendKeys("9874563210");
		addressBox.sendKeys("321, Main St");
		passengerFName1.sendKeys("John");
		passengerLName1.sendKeys("Doe");
		passengerFName2.sendKeys("John");
		passengerLName2.sendKeys("Doe");
	}

	public void enterPersonalDetails(String fname, String lname, String email, String phno, String addr) {
		fNameBox.sendKeys(fname);
		lNameBox.sendKeys(lname);
		emailBox.sendKeys(email);
		pNoBox.sendKeys(phno);
		addressBox.sendKeys(addr);

		nationality.click();
		nationalitySBox.sendKeys("iceland");
		js.executeScript("arguments[0].click()", selectNationality);

		currentCountry.click();
		countrySBox.sendKeys("iceland");
		js.executeScript("arguments[0].click()", selectCurrentCountry);
	}

	public void Passenger1Details() {
		passengerFName1.sendKeys("John");
		passengerLName1.sendKeys("Doe");
	}

	public void Passenger2Details() {
		passengerFName2.sendKeys("John");
		passengerLName2.sendKeys("Smith");
	}

	public void enterPassenger1Details() {
		passenger1FName.sendKeys("John");
		passenger1LName.sendKeys("Doe");
	}

	public void enterPassenger2AddDetails() {
		passenger2Nationality.sendKeys("Norway");
		passport2.sendKeys("987410256320145");
	}

	public void enterPassenger2Details() {
		passenger2FName.sendKeys("Jane");
		passenger2LName.sendKeys("Smith");
	}

	public void enterPassenger1AddDetails() {
		passenger1Nationality.sendKeys("Iceland");
		passport1.sendKeys("987410256320147");
	}

	public void paymentAndBooking() {
		js.executeScript("arguments[0].click()", checkBox);
		js.executeScript("arguments[0].click()", confirmBooking);
	}
}
