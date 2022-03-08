package com.trivia.champion;

public class Main {

    public static void main(String[] args) throws Exception  //static method
    {
        User user = LoginUtility.login();
        FlowManagerFactory flowManagerFactory = new FlowManagerFactory();
        FlowManager flowManager = flowManagerFactory.getFlowManager(user);
        flowManager.start();
    }
}
