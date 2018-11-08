package pageObjectTests;

import enums.BrowserType;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests4 {

    private void runBasicCheck() {
        WebDriver driver = BrowserFabric.getWebDriver(BrowserType.CHROME);
        try {
            driver.get("https://koel.dev/");
            String url = driver.getCurrentUrl();
            String title = driver.getTitle();
            Assert.assertTrue(url.contains("koel.dev"), "URL should contain koel.dev");
            Assert.assertTrue(title != null && title.length() > 0, "Title should not be empty");
        } finally {
            driver.quit();
        }
    }

        @Test
        public void loginTest_wrongCredentials_variant6() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.open();
            loginPage.login(username, wrongPassword);
            org.testng.Assert.assertTrue(loginPage.isErrorState());
        }

        @Test
        public void loginTest_CorrectCredentials_variant6() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.open();
            MainPage mainPage = loginPage.login(username, password);
            org.testng.Assert.assertTrue(mainPage.isOpen());
        }
}
// nov commit note 3 at 2018-11-08T13:00:00
