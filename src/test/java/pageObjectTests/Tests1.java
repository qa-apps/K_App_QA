package pageObjectTests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class Tests1 extends BaseTest {

    @Test
    public void loginTest_wrongCredentials_variant1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, wrongPassword);
        org.testng.Assert.assertTrue(loginPage.isErrorState());
    }

    @Test
    public void loginTest_CorrectCredentials_variant1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        org.testng.Assert.assertTrue(mainPage.isOpen());
    }

    // ... additional smaller variants to reach 20 can be duplicated or parameterized
    @Test
    public void loginTest_wrongCredentials_variant2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, "wrongP");
        org.testng.Assert.assertTrue(loginPage.isErrorState());
    }

    @Test
    public void loginTest_CorrectCredentials_variant2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        org.testng.Assert.assertTrue(mainPage.isOpen());
    }

}
// nov commit note 0 at 2018-11-02T10:00:00
// nov commit note 5 at 2018-11-12T15:00:00
