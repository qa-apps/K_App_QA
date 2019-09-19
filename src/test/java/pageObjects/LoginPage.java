package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private static Logger logger = LogManager.getLogger(MainPage.class);
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private WebElement getEmailField(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(LoginPageLocators.cssEmailLocator)));
        return driver.findElement(By.cssSelector(LoginPageLocators.cssEmailLocator));
    }
    private WebElement getPasswordField(){
        return driver.findElement(LoginPageLocators.byPassword);
    }
    private WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("button"));
    }

    public MainPage login(String username,String password){
        logger.warn("Attempt to log to application using " + username+" "+password);
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);

    }
    public void open(){
        driver.get("https://koelapp.testpro.io/");
    }

    public boolean isErrorState() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));
        } catch (NoSuchElementException | TimeoutException ignored){};

        return driver.findElements(By.cssSelector(".error")).size()==1;
    }
}

