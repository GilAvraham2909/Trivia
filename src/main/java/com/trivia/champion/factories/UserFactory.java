package com.trivia.champion.factories;


import com.trivia.champion.users.Admin;
import com.trivia.champion.users.Player;
import com.trivia.champion.users.User;

public class UserFactory {

    public User createUser(String name, String password, String type) {
        switch (type) {
            case "admin" -> { return new Admin(name, password, type); }
            case "user" -> { return new Player(name, password, type); }
            default -> { return null; }
        }
    }
}
