package com.trivia.champion.db;

import com.trivia.champion.Player;
import com.trivia.champion.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// NOT IMPLEMENTED
public class MongoDB{
    public void createDB() throws Exception {

    }

    public User getUserFromDB(String givenName) throws Exception {
        return null;
    }

    public int getPlayerScore(String givenName) throws Exception {
        return 0;
    }

    public boolean validateUser(@NotNull User user, String givenPass) throws Exception {
        return false;
    }

    public User addToDB(String givenName, String givenPass) throws Exception {
        return null;
    }

    public int updateScore(@NotNull Player player, int gameScore) throws Exception {
        return 0;
    }

    public List<Player> scoreBoard() throws Exception {
        return null;
    }

    public void closeConnection() throws Exception {

    }
}
