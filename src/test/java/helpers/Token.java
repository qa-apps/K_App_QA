package helpers;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Credentials;

import static io.restassured.RestAssured.given;

public class Token {
    public static String get(){
        Credentials credentials = new Credentials("koeluser06@testpro.io","te$t$tudent");
        Response response =
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/me")
                        .header("Content-Type","application/json")
                        .header("Accept", "application/json")
                        .body(credentials)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        JsonPath jsonPath = response.jsonPath();
        return "Bearer "+jsonPath.getString("token");}
}