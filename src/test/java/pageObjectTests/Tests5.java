package pageObjectTests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class Tests5 extends BaseTest {

    @Test
    public void loginTest_wrongCredentials_variant7() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, wrongPassword);
        org.testng.Assert.assertTrue(loginPage.isErrorState());
    }

    @Test
    public void loginTest_CorrectCredentials_variant7() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        org.testng.Assert.assertTrue(mainPage.isOpen());
    }

}
// nov commit note 4 at 2018-11-10T14:00:00
