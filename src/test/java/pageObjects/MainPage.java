package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private static Logger logger = LogManager.getLogger(MainPage.class);
    public MainPage(WebDriver driver) {

        super(driver);
    }
    private void clickPlusButton(){
        logger.info("Clicking plus button");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-plus-circle")));
        logger.info("Element is clickable");

        for (int i=0;i<50;i++){
            try{
                driver.findElement(By.cssSelector(".fa-plus-circle")).click();
                break;
            } catch (ElementClickInterceptedException xx){
                logger.error("We in catch block we got "+xx.getLocalizedMessage());
            }
        }
    }
    private WebElement getEditPlaylistField(){
        return driver.findElement(By.xpath("//*[@class='playlist playlist editing']/input"));
    }
    private WebElement getNewPlaylistFiled(){
        return driver.findElement(By.xpath("//*[@class='create']/input"));
    }

    public boolean isOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".home")));
        return driver.findElements(By.cssSelector(".home")).size()==1;
    }
    public String createPlaylist(String name){
        clickPlusButton();
        getNewPlaylistFiled().sendKeys(name);
        getNewPlaylistFiled().sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        String url = driver.getCurrentUrl();
        return url.split("/")[5];
    }



