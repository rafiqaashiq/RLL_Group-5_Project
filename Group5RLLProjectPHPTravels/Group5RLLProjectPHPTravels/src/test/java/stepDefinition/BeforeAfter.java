package stepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import listeners.Tools;

public class BeforeAfter extends Tools {

	@Before
	public void setUp(Scenario scenario) {
		Driver.init();
	}

	@After
	public void tearDown() {
		//driver.quit();
	}
}
