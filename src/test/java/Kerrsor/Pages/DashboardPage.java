package Kerrsor.Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class DashboardPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);
    private final Faker faker = new Faker();

    public DashboardPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "add-patient-btn")
    private WebElement addPatientButton;

    @FindBy(id = "add-patient-form")
    private WebElement patientAddingForm;

    @FindBy(id= "mrn")
    private WebElement MRNField;

    @FindBy(id= "firstName")
    private WebElement firstnameField;

    @FindBy(id= "lastName")
    private WebElement lastNameField;

    @FindBy(id= "dob")
    private WebElement DOBField;

    @FindBy(id= "discharge")
    private WebElement dischargeDateField;

    @FindBy(id= "phone")
    private WebElement phoneNumberField;

    @FindBy(id= "language")
    private WebElement languageDropdown;

    @FindBy(id= "timezone")
    private WebElement timeZoneDropdown;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;

    public void verifyAllFieldsAreDisplayed() {
        addPatientButton.click();

        List<WebElement> formFields = Arrays.asList(
                MRNField,
                firstnameField,
                lastNameField,
                DOBField,
                dischargeDateField,
                phoneNumberField,
                languageDropdown,
                timeZoneDropdown,
                submitButton
        );

        for(WebElement element : formFields) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
            } catch (Exception e) {
                logger.error("{} -- Element is not visible", element);
            }
        }

        logger.info("✅ All form fields are visible");
    }

    public void addingPatient() throws InterruptedException {

        verifyAllFieldsAreDisplayed();

        String MRN = String.valueOf(faker.number().numberBetween(1000, 9999));
        MRNField.clear();
        MRNField.sendKeys(MRN);

        String firstName = faker.name().firstName();
        firstnameField.clear();
        firstnameField.sendKeys(firstName);

        String lastName = faker.name().lastName();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);

        String phone = faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "").substring(0, 10);
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phone);

        Select language = new Select(languageDropdown);
        language.selectByIndex(1);

        Select timeZone = new Select(timeZoneDropdown);
        timeZone.selectByIndex(1);

        Thread.sleep(10000);
    }

}
