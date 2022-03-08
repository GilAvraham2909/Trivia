package com.trivia.champion;


public class UserFactory {

    public User createUser(String name, String password, String type) {
        switch (type) {
            case "admin" -> { return new Admin(name, password, type); }
            case "user" -> { return new Player(name, password, type); }
            default -> { return null; }
        }
    }
}
