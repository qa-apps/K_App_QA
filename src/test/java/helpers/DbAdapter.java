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

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            statement = connection.createStatement();

            String sql = "SELECT * from playlists p where user_id = " + userId;

            var result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                int user_id = result.getInt("user_id");
                String name = result.getString("name");

                var playlist = new Playlist(id, user_id, name);
                playlistList.add(playlist);
            }
        } catch (SQLException | ClassNotFoundException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (statement != null) {
                    connection.close();
                }
            } catch (SQLException ignored) {
            }// do nothing
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return playlistList;
    }//end main
    public static List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        final String USERNAME = "dbuser06";
        final String PASSWORD = "pa$$06";
        final String URL = "jdbc:mariadb://104.237.9.33/dbkoel";
        final String DRIVER = "org.mariadb.jdbc.Driver";

        Connection connection = null;
        Statement statement = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            statement = connection.createStatement();

            String sql = "SELECT * from artists";

            var result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String image = result.getString("image");




