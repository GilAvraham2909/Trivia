package com.trivia.champion;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException  //static method
    {
        FlowManager flowManager = FlowManager.getInstance();
        flowManager.start();
//        while (!flowManager.gameFinished) {
//
//        }
    }
}
