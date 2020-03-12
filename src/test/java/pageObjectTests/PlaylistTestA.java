package pageObjectTests;

import helpers.TestObjectGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class PlaylistTestA extends BaseTest{
    @Test
    public void playlistTests_createPlaylist_playlistCreatedA(){
        String name = faker.funnyName().name();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,name));
    }
    @Test
    public void playlistTests_renamePlaylist_playlistRenamedA(){
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
    public void playlistTests_createPlaylist_playlistCreated1A(){
        String name = faker.funnyName().name();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,name));
    }
    @Test
    public void playlistTests_renamePlaylist_playlistRenamed1A(){
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
    public void playlistTests_createPlaylist_playlistCreated2A(){
        String name = faker.funnyName().name();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.login(username, password);
        String playlistId = mainPage.createPlaylist(name);
        Assert.assertTrue(mainPage.checkPlaylistExist(playlistId,name));
    }
    @Test
    public void playlistTests_renamePlaylist_playlistRenamed2A(){
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
