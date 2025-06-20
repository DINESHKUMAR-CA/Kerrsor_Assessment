package Kerrsor.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserFactory {

	private static final Logger logger = LoggerFactory.getLogger(BrowserFactory.class);

	public static WebDriver startApplication(String browserName, String siteUrl) {

		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			logger.error("❌This browser isn’t compatible. Please use Chrome, Edge, Firefox, or Safari");
			throw new RuntimeException("❌Unsupported browser: " + browserName);
		}

		logger.info("✅Browser Started Successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(siteUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;
	}

	public static void quiteBrowser(WebDriver driver) {
		if (driver != null) {
			driver.quit();
			logger.info("✅Browser closed successfully");
		}
	}
}
