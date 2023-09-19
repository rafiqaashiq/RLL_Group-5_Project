package listeners;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Tools {

	protected static WebDriver driver;
	public static Logger logger;

	
	
	public Tools() {
		logger = Logger.getLogger("LogDemo");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
}
