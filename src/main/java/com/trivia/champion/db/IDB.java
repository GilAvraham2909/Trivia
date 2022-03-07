package com.trivia.champion.db;

import com.trivia.champion.Player;
import com.trivia.champion.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IDB {
    void createDB() throws Exception;

    User getUserFromDB(String givenName) throws Exception;

    int getPlayerScore(String givenName) throws Exception;

    boolean validateUser(@NotNull User user, String givenPass) throws Exception;

    User addToDB(String givenName, String givenPass) throws Exception;

    int updateScore(@NotNull Player player, int gameScore) throws Exception;

    List<Player> scoreBoard() throws Exception;

    void closeConnection() throws Exception;

}
