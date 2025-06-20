package Kerrsor.Tests;

import Kerrsor.Pages.BaseTest;
import Kerrsor.Pages.DashboardPage;
import org.testng.annotations.Test;
import Kerrsor.Pages.LoginPage;

public class LoginPageTest extends BaseTest {

    public DashboardPage dashboardPage;

    @Test
    public void loginToApplication() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providingCredentials();
    }

    @Test(dependsOnMethods = "loginToApplication")
    public void dashboardValidation() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.addingPatient();
        dashboardPage.verifyPatientDetailAdded();
    }
}
