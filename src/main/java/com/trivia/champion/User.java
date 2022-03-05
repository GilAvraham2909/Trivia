package com.trivia.champion;

public class User {
    private String name;
    private String password;
    private int score;
    private String type;

    public User(String name, String password, int score) {
        this.name = name;
        this.password = password;
        this.score = score;
        this.type = "user";
    }

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void makeAdmin() {
        this.type = "admin";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
