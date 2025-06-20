package Kerrsor.Pages;

import Kerrsor.utility.ConfigReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private final Faker faker = new Faker();

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id="username")
    private WebElement usernameField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(id = "add-patient-btn")
    private WebElement addPatientButton;


    public void providingCredentials() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(usernameField, passwordField, loginButton));
        usernameField.clear();
        usernameField.sendKeys(ConfigReader.getProperty("userName"));

        passwordField.clear();
        passwordField.sendKeys(ConfigReader.getProperty("password"));

        loginButton.click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOf(addPatientButton));
        logger.info("✅Successfully logged into the application!");

    }
}
