package Kerrsor.Pages;

import Kerrsor.utility.ConfigReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DashboardPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);
    private final Faker faker = new Faker();

    private String MRNumber = "";

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

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.elementToBeClickable(addPatientButton)).click();

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

        logger.info("✅All form fields are visible");
    }

    public void selectDateTime(WebDriver driver, String datetime) {
       
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime ldt = LocalDateTime.parse(datetime, inputFormat);

        int day = ldt.getDayOfMonth();
        String month = ldt.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // e.g., "June"
        int year = ldt.getYear();
        int hour = ldt.getHour();
        int minute = ldt.getMinute();

        // Step 2: Open calendar
        driver.findElement(By.id("calendarInput")).click(); // adjust locator

        // Step 3: Select year
        driver.findElement(By.xpath("//select[@class='year-selector']")).sendKeys(String.valueOf(year));

        // Step 4: Select month
        driver.findElement(By.xpath("//select[@class='month-selector']")).sendKeys(month);

        // Step 5: Select day
        driver.findElement(By.xpath("//td[text()='" + day + "']")).click();

        // Step 6: Select time (if separate dropdowns)
        Select hourDropdown = new Select(driver.findElement(By.id("hourDropdown")));
        hourDropdown.selectByVisibleText(String.format("%02d", hour)); // "15"

        Select minuteDropdown = new Select(driver.findElement(By.id("minuteDropdown")));
        minuteDropdown.selectByVisibleText(String.format("%02d", minute)); // "30"
    }


    public void addingPatient() throws InterruptedException {

        verifyAllFieldsAreDisplayed();

        String MRN = String.valueOf(faker.number().numberBetween(1000, 9999));
        MRNumber = MRN;
        MRNField.clear();
        MRNField.sendKeys(MRN);
        logger.info("✅Entered MRN: {}", MRN);

        String firstName = faker.name().firstName();
        firstnameField.clear();
        firstnameField.sendKeys(firstName);
        logger.info("✅Entered FirstName: {}", firstName);

        String lastName = faker.name().lastName();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        logger.info("✅Entered LastName: {}", lastName);

        DOBField.sendKeys(ConfigReader.getProperty("DateOfBirth"));
        logger.info("✅Entered DOB: {}", ConfigReader.getProperty("DateOfBirth"));

        String phoneNumber = faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "").substring(0, 10);
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
        logger.info("✅Entered Phone Number: {}", phoneNumber);

        Select select = new Select(languageDropdown);
        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            String dropdownValue = option.getText().trim();
            if (dropdownValue.equalsIgnoreCase(ConfigReader.getProperty("Language").trim())) {
                option.click();
                System.out.println("✅Selected language: " + dropdownValue);
                break;
            }
        }

        Select timeZone = new Select(timeZoneDropdown);
        List<WebElement> timezoneList = timeZone.getOptions();

        for (WebElement option : timezoneList) {
            String dropdownValue = option.getText().trim();
            if (dropdownValue.equalsIgnoreCase(ConfigReader.getProperty("TimeZone").trim())) {
                option.click();
                System.out.println("✅Selected language: " + dropdownValue);
                break;
            }
        }

        submitButton.click();

        Thread.sleep(10000);
    }

    public void verifyPatientDetailAdded() {

        try {

            By mrnLocator = By.xpath("//table//td[text()= '"+ MRNumber + "']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(mrnLocator));

            logger.info("✅Patient details successfully added in the table");

        } catch (Exception e) {
                logger.info("❌Error occurred:", e);
        }
    }

}
