package hybridTest;

import com.github.javafaker.Faker;
import enums.BrowserType;
import helpers.BrowserFabric;
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

public class RenamePlaylistUsingAPIandSelenium {
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