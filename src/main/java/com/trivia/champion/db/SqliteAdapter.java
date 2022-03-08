package com.trivia.champion.db;


import com.trivia.champion.users.Player;
import com.trivia.champion.users.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SqliteAdapter implements IDB {
    private SqliteDB sqliteDb;

    public SqliteAdapter(SqliteDB sqliteDb) {
        this.sqliteDb = sqliteDb;
    }

    @Override
    public User getUserFromDB(String givenName) throws Exception {
        return this.sqliteDb.getUserFromDB(givenName);
    }

    @Override
    public int getPlayerScore(String givenName) throws Exception {
        return sqliteDb.getPlayerScore(givenName);
    }

    @Override
    public boolean validateUser(@NotNull User user, String givenPass) throws Exception {
        return this.sqliteDb.validateUser(user, givenPass);
    }

    @Override
    public void createDB() throws Exception {
        this.sqliteDb.createDB();
    }

    @Override
    public User addToDB(String givenName, String givenPass) throws Exception {
        return this.sqliteDb.addToDB(givenName, givenPass);
    }

    @Override
    public int updateScore(@NotNull Player player, int gameScore) throws Exception {
        return this.sqliteDb.updateScore(player,gameScore);
    }

    @Override
    public List<Player> scoreBoard() throws Exception {
        return this.sqliteDb.scoreBoard();
    }

    @Override
    public void closeConnection() throws Exception {
        this.sqliteDb.closeConnection();
    }
}
