package pageObjectTests;

import com.github.javafaker.Faker;
import enums.BrowserType;
import helpers.BrowserFabric;
import helpers.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected WebDriver driver;
    protected Faker faker;
    protected String username;
    protected String password;
    protected String wrongPassword;
    protected int error_count = 0;
    @Parameters({"email", "password","wrongPassword", "browser"})
    @BeforeMethod
    public void startUp(String email, String password, String wrongPassword, String browser){
        username = email;
        this.password = password;
        this.wrongPassword = wrongPassword;
        BrowserType browserType = browser.equals("CHROME") ? BrowserType.CHROME : BrowserType.FIREFOX;
        driver = BrowserFabric.getWebDriver(browserType);

        faker = new Faker();
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if(iTestResult.getStatus()==iTestResult.FAILURE){
            ScreenShot.take(driver,iTestResult.getName());
        }
        driver.quit();
    }
}
