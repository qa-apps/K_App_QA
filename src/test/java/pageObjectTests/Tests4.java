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

    @Test public void b1(){ runBasicCheck(); }
    @Test public void b2(){ runBasicCheck(); }
    @Test public void b3(){ runBasicCheck(); }
    @Test public void b4(){ runBasicCheck(); }
    @Test public void b5(){ runBasicCheck(); }
    @Test public void b6(){ runBasicCheck(); }
    @Test public void b7(){ runBasicCheck(); }
    @Test public void b8(){ runBasicCheck(); }
    @Test public void b9(){ runBasicCheck(); }
    @Test public void b10(){ runBasicCheck(); }
    @Test public void b11(){ runBasicCheck(); }
    @Test public void b12(){ runBasicCheck(); }
    @Test public void b13(){ runBasicCheck(); }
    @Test public void b14(){ runBasicCheck(); }
    @Test public void b15(){ runBasicCheck(); }
    @Test public void b16(){ runBasicCheck(); }
    @Test public void b17(){ runBasicCheck(); }
    @Test public void b18(){ runBasicCheck(); }
    @Test public void b19(){ runBasicCheck(); }
    @Test public void b20(){ runBasicCheck(); }
}
