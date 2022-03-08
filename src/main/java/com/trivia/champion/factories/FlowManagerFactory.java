package com.trivia.champion.factories;

import com.trivia.champion.managers.AdminFlowManager;
import com.trivia.champion.managers.FlowManager;
import com.trivia.champion.managers.PlayerFlowManager;
import com.trivia.champion.users.User;

public class FlowManagerFactory {

    public FlowManager getFlowManager(User user) throws Exception {
        switch (user.getType()) {
            case "admin" -> { return new AdminFlowManager(user); }
            case "user" -> { return new PlayerFlowManager(user); }
            default -> {return null;}
        }
    }
}
