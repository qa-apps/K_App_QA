package pageObjectTests;

import enums.BrowserType;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests1 {

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
    public void test_1(){ runBasicCheck(); }
    @Test
    public void test_2(){ runBasicCheck(); }
    @Test
    public void test_3(){ runBasicCheck(); }
    @Test
    public void test_4(){ runBasicCheck(); }
    @Test
    public void test_5(){ runBasicCheck(); }
    @Test
    public void test_6(){ runBasicCheck(); }
    @Test
    public void test_7(){ runBasicCheck(); }
    @Test
    public void test_8(){ runBasicCheck(); }
    @Test
    public void test_9(){ runBasicCheck(); }
    @Test
    public void test_10(){ runBasicCheck(); }
    @Test
    public void test_11(){ runBasicCheck(); }
    @Test
    public void test_12(){ runBasicCheck(); }
    @Test
    public void test_13(){ runBasicCheck(); }
    @Test
    public void test_14(){ runBasicCheck(); }
    @Test
    public void test_15(){ runBasicCheck(); }
    @Test
    public void test_16(){ runBasicCheck(); }
    @Test
    public void test_17(){ runBasicCheck(); }
    @Test
    public void test_18(){ runBasicCheck(); }
    @Test
    public void test_19(){ runBasicCheck(); }
    @Test
    public void test_20(){ runBasicCheck(); }
}
// commit note 0 at 2018-06-05T12:00:00
// commit note 5 at 2018-08-03T09:00:00
// commit note 10 at 2018-09-02T18:00:00
