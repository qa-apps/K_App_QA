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
        playlistName = faker.artist().name();
        CreatePlaylistRequest createPlaylistRequest = new CreatePlaylistRequest(playlistName);
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
        CreatePlaylistResponse createPlaylistResponse = jsonPath.getObject("$",CreatePlaylistResponse.class);
        playlistId = createPlaylistResponse.getId();
        Assert.assertEquals(playlistName,createPlaylistResponse.getName());
        System.out.println(playlistId);
    }
    @AfterMethod
    public void tearDown(){
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
    public void getPlaylist(){

        Response response =



