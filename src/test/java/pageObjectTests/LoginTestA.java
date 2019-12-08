package pageObjectTests;

import listeners.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginTestA extends BaseTest{
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTest_CorrectCredentials_successfulLoginA(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        Assert.assertTrue(mainPage.isOpen());
        boolean pass = false;
        if(error_count==2){
            pass=true;
        }
        error_count++;
        Assert.assertTrue(pass);
    }
    @Test
    public void loginTest_wrongCredentials_redFrameA(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, wrongPassword);
        Assert.assertTrue(loginPage.isErrorState());


    }
    @Test
    public void loginTest_CorrectCredentials_successfulLogin1A(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        Assert.assertTrue(mainPage.isOpen());
    }
    @Test
    public void loginTest_wrongCredentials_redFrame1A(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, wrongPassword);
        Assert.assertTrue(loginPage.isErrorState());
    }


