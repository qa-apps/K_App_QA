package hybridTest;

import com.github.javafaker.Faker;
import enums.BrowserType;
import helpers.BrowserFabric;
import helpers.DbAdapter;
import helpers.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.CreatePlaylistRequest;
import models.CreatePlaylistResponse;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static io.restassured.RestAssured.given;

public class RenamePlaylistUsingAPISeleniumAndDB {
    private String token;
    private int playlistId;
    private WebDriver driver;
    private Faker faker;
    @BeforeClass
    public void runOnce(){
        token = Token.get();
    }
    @BeforeMethod
    public void startUp(){
        faker = new Faker();
        var name = faker.funnyName().name();
        var createPlaylistRequest = new CreatePlaylistRequest(name);
        Response response =
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/playlist")
                        .header("Content-Type","application/json")
                        .header("Accept", "application/json")
                        .header("Authorization",token)
                        .body(createPlaylistRequest)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath jsonPath = response.jsonPath();
        var createPlaylistResponse = jsonPath.getObject("$",CreatePlaylistResponse.class);
        playlistId = createPlaylistResponse.getId();

        driver = BrowserFabric.getWebDriver(BrowserType.CHROME);
        System.out.println(playlistId);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
        given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist/"+playlistId)
                .header("Authorization",token)
                .when()
                .delete()
                .then()
                .extract()
                .response();
    }
    @Test
    public void renamePlaylist() throws InterruptedException {
        var newName = faker.cat().name();
        var loginPage = new LoginPage(driver);
        loginPage.open();
        var mainPage = loginPage.login("koeluser06@testpro.io","te$t$tudent");
        mainPage.renamePlaylist(playlistId+"",newName);
        var playlist = DbAdapter.getPlaylistById(playlistId);
        Assert.assertNotNull(playlist);
        Assert.assertEquals(newName,playlist.getName());
    }
}
