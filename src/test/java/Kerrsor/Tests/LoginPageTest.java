package Kerrsor.Tests;

import Kerrsor.Pages.BaseTest;
import org.testng.annotations.Test;
import Kerrsor.Pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginToApplication() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providingCredentials();
    }
}
