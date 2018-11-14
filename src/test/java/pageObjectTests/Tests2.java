package pageObjectTests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class Tests2 extends BaseTest {

    @Test
    public void loginTest_wrongCredentials_variant3() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, wrongPassword);
        org.testng.Assert.assertTrue(loginPage.isErrorState());
    }

    @Test
    public void loginTest_CorrectCredentials_variant3() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        org.testng.Assert.assertTrue(mainPage.isOpen());
    }

    @Test
    public void loginTest_wrongCredentials_variant4() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, "invalid");
        org.testng.Assert.assertTrue(loginPage.isErrorState());
    }

}
// nov commit note 1 at 2018-11-04T11:00:00
// nov commit note 6 at 2018-11-14T16:00:00
