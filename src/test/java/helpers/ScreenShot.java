package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public static void take(WebDriver driver, String screenshotName){
        try{
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File file = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./screenshots/"+screenshotName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
