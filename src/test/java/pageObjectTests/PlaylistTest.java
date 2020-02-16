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
    public void playlistTests_renamePlaylist_playlistRenamed(){
        String name = TestObjectGenerator.randomString(8);
        String newName = faker.ancient().god();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        mainPage.renamePlaylist(playlistId,newName);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,newName));
    }
    @Test
    public void playlistTests_createPlaylist_playlistCreated1(){
        String name = faker.funnyName().name();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,name));
    }
    @Test
    public void playlistTests_renamePlaylist_playlistRenamed1(){
        String name = TestObjectGenerator.randomString(8);
        String newName = faker.ancient().god();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        mainPage.renamePlaylist(playlistId,newName);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,newName));
    }
    @Test
    public void playlistTests_createPlaylist_playlistCreated2(){
        String name = faker.funnyName().name();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,name));
    }
    @Test
    public void playlistTests_renamePlaylist_playlistRenamed2(){
        String name = TestObjectGenerator.randomString(8);
        String newName = faker.ancient().god();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        mainPage.renamePlaylist(playlistId,newName);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,newName));
    }
}
