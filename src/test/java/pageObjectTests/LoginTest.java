package pageObjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginTest extends BaseTest{
    @Test
    public void loginTest_CorrectCredentials_successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password+"nnn");
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test(enabled = false)
    public void loginTest_wrongCredentials_redFrame(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, wrongPassword);
        Assert.assertTrue(loginPage.isErrorState());
    }
    @Test(enabled = false)
    public void loginTest_CorrectCredentials_successfulLogin1(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginTest_wrongCredentials_redFrame1(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, wrongPassword);
        Assert.assertTrue(loginPage.isErrorState());
    }
    @Test
    public void loginTest_CorrectCredentials_successfulLogin2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginTest_wrongCredentials_redFrame2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, wrongPassword);
        Assert.assertTrue(loginPage.isErrorState());
    }
}


