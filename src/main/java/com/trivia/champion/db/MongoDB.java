package com.trivia.champion.db;

import com.trivia.champion.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// NOT IMPLEMENTED
public class MongoDB {
    public void createDB() throws Exception {

    }

    public User getUserFromDB(String givenName) throws Exception {
        return null;
    }

    public boolean validateUser(@NotNull User user, String givenPass) throws Exception {
        return false;
    }

    public User addToDB(String givenName, String givenPass) throws Exception {
        return null;
    }

    public int updateScore(@NotNull User user, int gameScore) throws Exception {
        return 0;
    }

    public List<User> scoreBoard() throws Exception {
        return null;
    }
}
