package com.trivia.champion.users;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class User {
    private String name;
    private String password;
    private String type;

public User(String name, String password, String type) {
    this.name = name;
    this.password = password;
    this.type = type;
}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }
}
