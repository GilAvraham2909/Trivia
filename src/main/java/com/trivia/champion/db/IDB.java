package com.trivia.champion.db;

import com.trivia.champion.User;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public interface IDB {
    void createDB() throws Exception;

    User getUserFromDB(String givenName) throws Exception;

    boolean validateUser(@NotNull User user, String givenPass) throws Exception;

    User addToDB(String givenName, String givenPass) throws Exception;

    int updateScore(@NotNull User user, int gameScore) throws Exception;

    List<User> scoreBoard() throws Exception;

}
