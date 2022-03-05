package com.trivia.champion.db;

import com.trivia.champion.User;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class SqliteDB {


    private String jdbcUrl = "jdbc:sqlite:users.db";
    private Connection connection = DriverManager.getConnection(jdbcUrl);

//        String sql = "SELECT * FROM users WHERE name='gil'";
//        String sql1 = "DELETE FROM users WHERE name='gil'";

    public SqliteDB() throws SQLException {
    }

    public void createDB() throws SQLException {
        String sql = "create table users (name varchar(25), password varchar(25), score int)";
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(sql);
    }

    public User getUserFromDB(String givenName) throws SQLException {
        String sql = "SELECT * FROM users WHERE name='" + givenName + "'";
        Statement statement = this.connection.createStatement();
        statement.execute(sql);
        ResultSet result = statement.getResultSet();
        if (!result.next()){
            return null;
        }
        String name = result.getString("name");
        String pass = result.getString("password");
        int score = result.getInt("score");
        return new User(name, pass, score);

    }

    public boolean validateUser(@NotNull User user, String givenPass) {
        return givenPass.equals(user.getPassword());
    }

    public User addToDB(String givenName, String givenPass) throws SQLException {
        String sql1 = "insert into users values ('" + givenName + "', '" + givenPass + "', 0)";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql1);
        if (rows == 0) {
            throw new SQLException("could not add user to DB");
        }
        return getUserFromDB(givenName);
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

    public List<User> getTop10() throws SQLException {
        List<User> usersList = null;
        String sql = "select * from users order by score desc LIMIT 10";
        Statement statement = this.connection.createStatement();
        statement.execute(sql);
        ResultSet result = statement.getResultSet();
        while (result.next()) {
            String name = result.getString("name");
            int score = result.getInt("score");
            usersList.add(new User(name, score));
        }
        return usersList;
    }
}
