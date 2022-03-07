package com.trivia.champion;

import com.trivia.champion.db.DbAdapter;
import com.trivia.champion.db.IDB;
import com.trivia.champion.ui.UiAdapter;

import java.io.IOException;
import java.sql.SQLException;

import static com.trivia.champion.utils.Constants.NUM_OF_WELCOME_PAGE_OPTIONS;

public class Main {

    public static void main(String[] args) throws Exception  //static method
    {
        User user = login();
        FlowManagerFactory flowManagerFactory = new FlowManagerFactory();
        FlowManager flowManager = flowManagerFactory.getFlowManager(user);
        flowManager.start();
//        while (!flowManager.gameFinished) {
//
//        }
    }

//    public static User login() {
//        UserFactory userFactory = new UserFactory();
//        return userFactory.createUser("","","admin");
//    }

    public static User login() throws Exception {
        DbAdapter dbAdapter = DbAdapter.getInstance();
        IDB db = dbAdapter.getDb();
        UiAdapter uiAdapter = new UiAdapter();
        ILoginUi display = uiAdapter.getLoginUiOutput();
        IInputGetter inputGetter = uiAdapter.getUiInput();
        display.showWelcomePage();
        int userChoice = inputGetter.getIntFromUser(NUM_OF_WELCOME_PAGE_OPTIONS);
        User user = null;
        switch (userChoice) {
            // login
            case 1: {
                while (true) {
                    display.askForUserName();
                    String registeredUsername = inputGetter.getStringFromUser();
                    user = db.getUserFromDB(registeredUsername);
                    if (user != null) {
                        break;
                    }
                    display.couldNotFindUser();
                    userChoice = inputGetter.getIntFromUser(NUM_OF_WELCOME_PAGE_OPTIONS);
                    if (userChoice == 2) {
                        break;
                    }
                }
                if (user != null) {
                    display.askForUserPassword();
                    String registeredPassword = inputGetter.getStringFromUser();
                    while (!db.validateUser(user, registeredPassword)) {
                        display.incorrectPassword();
                        registeredPassword = inputGetter.getStringFromUser();
                    }
                    db.closeConnection();
                    return user;
                }
            }
            // register
            case 2: {
                display.askForUserName();
                String newUsername = inputGetter.getStringFromUser();
                while (db.getUserFromDB(newUsername) != null) {
                    display.existingUser();
                    newUsername = inputGetter.getStringFromUser();
                }
                display.askForUserPassword();
                String newPassword = inputGetter.getStringFromUser();
                user = db.addToDB(newUsername, newPassword);
                break;
            }
        }
        db.closeConnection();
        return user;
    }
}
