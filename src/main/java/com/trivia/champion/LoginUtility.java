package com.trivia.champion;

import com.trivia.champion.db.IDB;
import com.trivia.champion.db.SqliteAdapter;
import com.trivia.champion.db.SqliteDB;
import com.trivia.champion.ui.UiAdapter;

import static com.trivia.champion.utils.Constants.NUM_OF_WELCOME_PAGE_OPTIONS;

public class LoginUtility {

    private LoginUtility() {
    }

    public static User login() throws Exception {
        IDB db = new SqliteAdapter(new SqliteDB());
        UiAdapter uiAdapter = UiAdapter.getInstance();
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
