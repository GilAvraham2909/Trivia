package com.trivia.champion.db;

import com.trivia.champion.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// NOT IMPLEMENTED
public class MongoDB implements IDB{
    @Override
    public void createDB() throws Exception {

    }

    @Override
    public User getUserFromDB(String givenName) throws Exception {
        return null;
    }

    @Override
    public boolean validateUser(@NotNull User user, String givenPass) throws Exception {
        return false;
    }

    @Override
    public User addToDB(String givenName, String givenPass) throws Exception {
        return null;
    }

    @Override
    public int updateScore(@NotNull User user, int gameScore) throws Exception {
        return 0;
    }

    @Override
    public List<User> scoreBoard() throws Exception {
        return null;
    }
}
