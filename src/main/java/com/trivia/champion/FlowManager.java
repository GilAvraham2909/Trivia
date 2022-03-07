package com.trivia.champion;

import com.trivia.champion.categories.Categories;
import com.trivia.champion.db.SqliteAdapter;
import com.trivia.champion.db.IDB;
import com.trivia.champion.db.SqliteDB;
import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.ui.UiAdapter;

import java.io.IOException;
import java.util.List;

import static com.trivia.champion.utils.Constants.*;

// singleton class
public class FlowManager {
    public boolean quitGame = false;
    UiAdapter uiAdapter = UiAdapter.getInstance();
    private IPlayerUi display = uiAdapter.getUiOutput();
    private IInputGetter inputGetter = uiAdapter.getUiInput();
    private RoundManager roundManager = new RoundManager();
    private int currentTotalScore;
    private SqliteDB sql = new SqliteDB();
    private IDB db = new SqliteAdapter(sql);
    private User user = null;

    private static FlowManager single_instance = null;

    private FlowManager() throws Exception {
    }

    public static FlowManager getInstance() throws Exception {
        if (single_instance == null)
            single_instance = new FlowManager();
        return single_instance;
    }

    public void start() throws Exception {
        this.user = login();
        display.greetUser(user.getName(), user.getScore());

        while (!quitGame) {
            String category = getCategory();
            if (category == null) {
                quitGame = true;
                return;
            }
            Difficulty difficulty = getDifficulty(category);
            if (difficulty == null) {
                quitGame = true;
                return;
            }
            gameManagement(category, difficulty, user);
        }
    }

    public void gameManagement(String category, Difficulty difficulty, User user) throws Exception {
        int roundScore = roundManager.startRound(category, difficulty);
        this.currentTotalScore += roundScore;
        // save the new score in the DB
        int userScore = db.updateScore(user, this.currentTotalScore);
        display.showTotalScore(userScore);
        getScoreBoard();
    }

    private String getCategory() throws IllegalStateException, IOException, InterruptedException {
        GameModeAdapter gameModeAdapter = new GameModeAdapter();
        Categories categories = gameModeAdapter.getCategoriesType();
        display.showMainMenu(categories.getCategories());
        int categoryIndex = inputGetter.getIntFromUser(AppConfig.numOfCategoryOptions);
        return categories.getCategory(categoryIndex);
    }

    private Difficulty getDifficulty(String category) throws IllegalStateException {
        display.showDifficultyLevel(category);
        int difficulty = inputGetter.getIntFromUser(NUM_OF_DIFFICULTY_OPTIONS);
        return switch (difficulty) {
            case 1 -> Difficulty.Easy;
            case 2 -> Difficulty.Normal;
            case 3 -> Difficulty.Hard;
            case 4 -> null;
            default -> throw new IllegalStateException("Unexpected value: " + difficulty);
        };
    }

    public void getScoreBoard() throws Exception {
        List<User> usersList = this.db.scoreBoard();
        display.scoreBoard(usersList, this.user.userPlace(usersList));
    }

    public User login() throws Exception {
        display.showWelcomePage();
        int userChoice = inputGetter.getIntFromUser(NUM_OF_WELCOME_PAGE_OPTIONS);
        User user = null;
        switch (userChoice) {
            // login
            case 1: {
                while (true) {
                    display.askForUserName();
                    String registeredUsername = inputGetter.getStringFromUser();
                    user = this.db.getUserFromDB(registeredUsername);
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
                    while (!this.db.validateUser(user, registeredPassword)) {
                        display.incorrectPassword();
                        registeredPassword = inputGetter.getStringFromUser();
                    }
                    return user;
                }
            }
            // register
            case 2: {
                display.askForUserName();
                String newUsername = inputGetter.getStringFromUser();
                while (this.db.getUserFromDB(newUsername) != null) {
                    display.existingUser();
                    newUsername = inputGetter.getStringFromUser();
                }
                display.askForUserPassword();
                String newPassword = inputGetter.getStringFromUser();
                user = this.db.addToDB(newUsername, newPassword);
                break;
            }
        }
        return user;
    }
}
