package pageObjectTests;

import helpers.TestObjectGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class PlaylistTest extends BaseTest{
    @Test
    public void playlistTests_createPlaylist_playlistCreated(){
        String name = faker.funnyName().name();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,name));
    }
    @Test
