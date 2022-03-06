package com.trivia.champion;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class User {
    private String name;
    private String password;
    private int score;
    private String type;

    public User(String name, String password, int score, String type) {
        this.name = name;
        this.password = password;
        this.score = score;
        this.type = type;
    }

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int userPlace(@NotNull List<User> usersList) {
        int i = 1;
        for (User user : usersList) {
            if (user.getName().equals(this.name))
                break;
            i++;
        }
        return i;
    }


}
