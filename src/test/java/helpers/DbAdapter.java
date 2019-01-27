package helpers;

import models.Artist;
import models.Playlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbAdapter {
    public static List<Playlist> getPlaylistByUserId(int userId) {
        List<Playlist> playlistList = new ArrayList<>();
        final String USERNAME = "dbuser06";
        final String PASSWORD = "pa$$06";
        final String URL = "jdbc:mariadb://104.237.9.33/dbkoel";
        final String DRIVER = "org.mariadb.jdbc.Driver";

        Connection connection = null;
        Statement statement = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(DRIVER);
