package com.trivia.champion.db;

import com.trivia.champion.User;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Map;

public class SqliteDB {


    private String jdbcUrl = "jdbc:sqlite:users.db";
    private Connection connection = DriverManager.getConnection(jdbcUrl);

//        String sql = "SELECT * FROM users WHERE name='gil'";
//        String sql1 = "DELETE FROM users WHERE name='gil'";

    public SqliteDB() throws SQLException {
    }


    public User getUser(Map<String, String> userMap) throws SQLException {
        User user = getUserFromDB(userMap.get("userName"), userMap.get("userPassword"));
        if (user != null) {
            return user;
        }
        return addToDB(userMap.get("userName"), userMap.get("userPassword"));
    }

    public void createDB() throws SQLException {
        String sql = "create table users (name varchar(25), password varchar(25), score int)";
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("Table created");
    }

    public User getUserFromDB(String givenName, String givenPass) throws SQLException {
        String sql = "SELECT * FROM users WHERE name='" + givenName + "' AND password='" + givenPass + "'";
        Statement statement = this.connection.createStatement();
        statement.execute(sql);
        ResultSet result = statement.getResultSet();
        result.next();
        String name = result.getString("name");
        String pass = result.getString("password");
        int score = result.getInt("score");
        return new User(name, pass, score);

    }

    public User addToDB(String name, String pass) throws SQLException {
        String sql1 = "insert into users values ('" + name + "', '" + pass + "', 0)";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql1);
        if (rows == 0) {
            throw new SQLException("could not add user to DB");
        }
        return getUserFromDB(name, pass);
    }

    public int updateScore(@NotNull User user, int gameScore) throws SQLException {
//        update 'users' set score='50' where name='ofir'
        int score = user.getScore() + gameScore;
        String sql1 = "update 'users' set score='" + score + "' where name='" + user.getName() + "'";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql1);
        if (rows == 0) {
            throw new SQLException("could not add user to DB");
        }
        return score;
    }
}
