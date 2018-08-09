package pageObjectTests;

import enums.BrowserType;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests2 {

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
    public void t1(){ runBasicCheck(); }
    @Test
    public void t2(){ runBasicCheck(); }
    @Test
    public void t3(){ runBasicCheck(); }
    @Test
    public void t4(){ runBasicCheck(); }
    @Test
    public void t5(){ runBasicCheck(); }
    @Test
    public void t6(){ runBasicCheck(); }
    @Test
    public void t7(){ runBasicCheck(); }
    @Test
    public void t8(){ runBasicCheck(); }
    @Test
    public void t9(){ runBasicCheck(); }
    @Test
    public void t10(){ runBasicCheck(); }
    @Test
    public void t11(){ runBasicCheck(); }
    @Test
    public void t12(){ runBasicCheck(); }
    @Test
    public void t13(){ runBasicCheck(); }
    @Test
    public void t14(){ runBasicCheck(); }
    @Test
    public void t15(){ runBasicCheck(); }
    @Test
    public void t16(){ runBasicCheck(); }
    @Test
    public void t17(){ runBasicCheck(); }
    @Test
    public void t18(){ runBasicCheck(); }
    @Test
    public void t19(){ runBasicCheck(); }
    @Test
    public void t20(){ runBasicCheck(); }
}
// commit note 1 at 2018-06-10T12:00:00
// commit note 6 at 2018-08-09T09:00:00
