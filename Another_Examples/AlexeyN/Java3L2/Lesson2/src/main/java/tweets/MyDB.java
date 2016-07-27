package tweets;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tomag on 18.07.2016.
 */
class MyDB {
    private final String URL = "jdbc:sqlite:db.db";
    private final String DRIVER = "sql.sqlite.JDBC";

    MyDB() {

    }

    List<String> stringFromFile(String f) {
       List<String> result = null;
        try {
            byte[] buff = Files.readAllBytes(Paths.get(f));
            result = Arrays.asList(new String(buff).trim().split(";"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

	//NOTE: имя метода слегка сбивает с толку.
    void voidQuery(List<String> query) {
        try (
                Connection connection = DriverManager.getConnection(URL);
                Statement stmt = connection.createStatement();
                ) {
            for (String s : query
                 ) {
                stmt.execute(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //вывести имена (username) тех пользователей, на которых подписан aruizca;
    List<String> getUsersByFollower(String follower) {
        List<String> result = new ArrayList<>();
        String query = "select username from users,followers where followers.user_from = '"+follower+"' and followers.user_to = users.login";
        try (
                Connection connection = DriverManager.getConnection(URL);
                Statement stmt = connection.createStatement();
                ) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //подсчет кол-ва пользователей
    int getUserCount() {
        int count = 0;
        String query = "select count() from users";
        try (
                Connection connection = DriverManager.getConnection(URL);
                Statement stmt = connection.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(query);
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    //вывести твиты тех пользователей, на которых подписан aruizca, сортировка по дате;
    List<String> getSubTweetsByUser(String name) {
        List<String> result = new ArrayList<>();
        String query = "select message,date from tweets,followers where followers.user_from ='"+name+"'and followers.user_to = tweets.login order by date";
        try (
                Connection connection = DriverManager.getConnection(URL);
                Statement stmt = connection.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString("message")+" "+rs.getString("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //выввести кол-во подписок пользователей
    List<String> getSubscriptionsCount() {
        List<String> result = new ArrayList<>();

        String query = "select user_to, count(user_to) from followers group by user_to";
        try (
                Connection connection = DriverManager.getConnection(URL);
                Statement stmt = connection.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString(1)+" "+rs.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
