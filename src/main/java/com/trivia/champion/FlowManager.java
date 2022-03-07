package com.trivia.champion;

public abstract class FlowManager {
    private User user;

    public FlowManager(User user) throws Exception {
        this.user = user;
    }

    public abstract void start() throws Exception;
}

