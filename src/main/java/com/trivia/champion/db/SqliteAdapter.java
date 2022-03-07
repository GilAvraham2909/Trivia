package com.trivia.champion.db;


import com.trivia.champion.User;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class SqliteAdapter implements IDB {
    private SqliteDB sqliteDb;

    public SqliteAdapter (SqliteDB sqliteDb){
        this.sqliteDb = sqliteDb;
    }

    @Override
    public void createDB() throws Exception {
        this.sqliteDb.createDB();
    }

    @Override
    public User getUserFromDB(String givenName) throws Exception {
        return sqliteDb.getUserFromDB(givenName);
    }

    @Override
    public boolean validateUser(@NotNull User user, String givenPass) throws Exception {
        return  this.sqliteDb.validateUser(user,givenPass);
    }

    @Override
    public User addToDB(String givenName, String givenPass) throws Exception {
        return  this.sqliteDb.addToDB(givenName,givenPass);
    }

    @Override
    public int updateScore(@NotNull User user, int gameScore) throws Exception {
        return  this.sqliteDb.updateScore(user,gameScore);
    }

    @Override
    public List<User> scoreBoard() throws Exception {
        return  this.sqliteDb.scoreBoard();
    }
}
