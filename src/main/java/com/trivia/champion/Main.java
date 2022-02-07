package com.trivia.champion;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException  //static method
    {
        FlowManager flowManager = FlowManager.getInstance();
        flowManager.start();
//        while (!flowManager.gameFinished) {
//
//        }
    }
}
