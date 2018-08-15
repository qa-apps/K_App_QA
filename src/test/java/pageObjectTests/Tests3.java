package pageObjectTests;

import enums.BrowserType;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests3 {

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

    @Test public void a1(){ runBasicCheck(); }
    @Test public void a2(){ runBasicCheck(); }
    @Test public void a3(){ runBasicCheck(); }
    @Test public void a4(){ runBasicCheck(); }
    @Test public void a5(){ runBasicCheck(); }
    @Test public void a6(){ runBasicCheck(); }
    @Test public void a7(){ runBasicCheck(); }
    @Test public void a8(){ runBasicCheck(); }
    @Test public void a9(){ runBasicCheck(); }
    @Test public void a10(){ runBasicCheck(); }
    @Test public void a11(){ runBasicCheck(); }
    @Test public void a12(){ runBasicCheck(); }
    @Test public void a13(){ runBasicCheck(); }
    @Test public void a14(){ runBasicCheck(); }
    @Test public void a15(){ runBasicCheck(); }
    @Test public void a16(){ runBasicCheck(); }
    @Test public void a17(){ runBasicCheck(); }
    @Test public void a18(){ runBasicCheck(); }
    @Test public void a19(){ runBasicCheck(); }
    @Test public void a20(){ runBasicCheck(); }
}
// commit note 2 at 2018-06-15T12:00:00
// commit note 7 at 2018-08-15T09:00:00
