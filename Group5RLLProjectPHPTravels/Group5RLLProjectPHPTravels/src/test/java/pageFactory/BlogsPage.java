package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogsPage {

	@FindBy(linkText = "Where to Eat in Rome During Holidays")
	static WebElement clickpage;

	public BlogsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ClickPage() {
		clickpage.click();
	}
}
