package pageObjectTests;

import enums.BrowserType;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests5 {

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

    @Test public void c1(){ runBasicCheck(); }
    @Test public void c2(){ runBasicCheck(); }
    @Test public void c3(){ runBasicCheck(); }
    @Test public void c4(){ runBasicCheck(); }
    @Test public void c5(){ runBasicCheck(); }
    @Test public void c6(){ runBasicCheck(); }
    @Test public void c7(){ runBasicCheck(); }
    @Test public void c8(){ runBasicCheck(); }
    @Test public void c9(){ runBasicCheck(); }
    @Test public void c10(){ runBasicCheck(); }
    @Test public void c11(){ runBasicCheck(); }
    @Test public void c12(){ runBasicCheck(); }
    @Test public void c13(){ runBasicCheck(); }
    @Test public void c14(){ runBasicCheck(); }
    @Test public void c15(){ runBasicCheck(); }
    @Test public void c16(){ runBasicCheck(); }
    @Test public void c17(){ runBasicCheck(); }
    @Test public void c18(){ runBasicCheck(); }
    @Test public void c19(){ runBasicCheck(); }
    @Test public void c20(){ runBasicCheck(); }
}
// commit note 4 at 2018-06-25T12:00:00
// commit note 9 at 2018-08-27T09:00:00
// commit note 14 at 2018-10-01T08:00:00
// commit note 19 at 2018-12-18T13:00:00
