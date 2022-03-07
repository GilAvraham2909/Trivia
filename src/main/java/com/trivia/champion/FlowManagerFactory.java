package com.trivia.champion;

public class FlowManagerFactory {

    public FlowManager getFlowManager(User user) throws Exception {
        switch (user.getType()) {
            case "admin" -> { return new AdminFlowManager(user); }
            case "user" -> { return new PlayerFlowManager(user); }
            default -> {return null;}
        }
    }
}
