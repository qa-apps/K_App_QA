package simpleTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SimpleTest {
    WebDriver driver;
    WebDriverWait wait;
    FluentWait<WebDriver> fluentWait;
    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,10,100);
        fluentWait = new FluentWait<WebDriver>(driver)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .pollingEvery(Duration.ofMillis(100))
                .withTimeout(Duration.ofSeconds(10));
        driver.get("https://koelapp.testpro.io/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void loginTest_correctCredentials_loggedToApp() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button"));

        emailField.sendKeys("koeluser06@testpro.io");
        passwordField.sendKeys("te$t$tudent"); // "WrongPassword"
        loginButton.click();

//        boolean logged = false;
//        try{
//            driver.findElement(By.className("home"));
//            logged=true;
//        } catch (NoSuchElementException ignored){}


//        boolean logged = driver.findElement(By.cssSelector(".home")).isDisplayed();
//        Assert.assertTrue(logged);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='home active']")));
        List<WebElement> homes = driver.findElements(By.xpath("//*[@class='home active']"));
        Assert.assertEquals(1,homes.size());
    }

    @Test
    public void loginTest_wrongCredentials_errorFrame() {
        fluentWait.until(x-> x.findElement(By.xpath("//*[@type='email']")).isDisplayed());
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button"));

        emailField.sendKeys("koeluser06@testpro.io");
        passwordField.sendKeys("WrongPassword");
        loginButton.click();

        fluentWait.until(x->x.findElement(By.cssSelector(".error")));
        List<WebElement> homes = driver.findElements(By.cssSelector(".error"));
        Assert.assertEquals(1,homes.size());
    }
}
