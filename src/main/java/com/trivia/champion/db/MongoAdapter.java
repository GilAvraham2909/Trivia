package com.trivia.champion.db;

import com.trivia.champion.users.Player;
import com.trivia.champion.users.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MongoAdapter implements IDB {
    private MongoDB mongoDB;

    public MongoAdapter(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public void createDB() throws Exception {
        this.mongoDB.createDB();
    }

    @Override
    public User getUserFromDB(String givenName) throws Exception {
        return this.mongoDB.getUserFromDB(givenName);
    }

    @Override
    public int getPlayerScore(String givenName) throws Exception {
        return 0;
    }

    @Override
    public boolean validateUser(@NotNull User user, String givenPass) throws Exception {
        return this.mongoDB.validateUser(user, givenPass);
    }

    @Override
    public User addToDB(String givenName, String givenPass) throws Exception {
        return this.mongoDB.addToDB(givenName, givenPass);
    }

    @Override
    public int updateScore(@NotNull Player player, int gameScore) throws Exception {
        return this.mongoDB.updateScore(player, gameScore);
    }

    @Override
    public List<Player> scoreBoard() throws Exception {
        return this.mongoDB.scoreBoard();
    }

    @Override
    public void closeConnection() throws Exception {

    }
}
