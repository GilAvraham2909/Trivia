package com.trivia.champion;

import com.trivia.champion.managers.FlowManager;
import com.trivia.champion.factories.FlowManagerFactory;
import com.trivia.champion.users.User;
import com.trivia.champion.utils.LoginUtility;

public class Main {

    public static void main(String[] args) throws Exception  //static method
    {
        User user = LoginUtility.login();
        FlowManagerFactory flowManagerFactory = new FlowManagerFactory();
        FlowManager flowManager = flowManagerFactory.getFlowManager(user);
        flowManager.start();
    }
}
