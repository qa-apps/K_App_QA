package koelTests;

import com.github.javafaker.Faker;
import helpers.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.CreatePlaylistRequest;
import models.CreatePlaylistResponse;
import models.RenamePlaylistRequest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlaylistTests {
    private Faker faker;
    private int playlistId;
    private String playlistName;
    private String token;
    @BeforeClass
    public void runOnce(){
        token = Token.get();
    }
    @BeforeMethod
    public void startUp(){
        faker = new Faker();


