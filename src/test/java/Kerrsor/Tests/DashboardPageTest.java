package Kerrsor.Tests;

import Kerrsor.Pages.BaseTest;
import Kerrsor.Pages.DashboardPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeMethod
    public void setupDashboardPage() {
        dashboardPage = new DashboardPage(driver);;
    }

    @Test
    public void addNewPatientForm() throws InterruptedException {
        dashboardPage.addingPatient();
    }
}
