package Kerrsor.Pages;

import Kerrsor.utility.BrowserFactory;
import Kerrsor.utility.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;

    public ConfigReader configReader = new ConfigReader();

    @BeforeSuite
    public void setUp() {
        driver = BrowserFactory.startApplication(configReader.getProperty("browser"), configReader.getProperty("testURL"));
    }



//    @AfterSuite
//    public void tearDown() {
//        BrowserFactory.quiteBrowser(driver);
//    }
}
