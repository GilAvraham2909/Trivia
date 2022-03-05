package com.trivia.champion;

import com.trivia.champion.db.SqliteDB;
import com.trivia.champion.enums.Category;
import com.trivia.champion.enums.Difficulty;

import java.io.IOException;
import java.sql.SQLException;

import static com.trivia.champion.utils.Constants.*;

// singleton class
public class FlowManager {
    public boolean gameFinished = false;
    //new UiAdapter

    //TODO private IShow display = uiAdapter(CONSOLE);
    private IPlayerUi display = PlayerConsole.getInstance();
    private InputGetter inputGetter = new InputGetter();
    private RoundManager roundManager = new RoundManager();
    private int currentTotalScore;
    private SqliteDB db = new SqliteDB();

    private static FlowManager single_instance = null;

    private FlowManager() throws SQLException {}

    public static FlowManager getInstance() throws SQLException {
        if (single_instance == null)
            single_instance = new FlowManager();
        return single_instance;
    }

    public void start() throws IOException, InterruptedException, SQLException {
        User user = login();
        display.greetUser(user.getName(),user.getScore());
        Category category = getCategory();
        if (category == null) {
            gameFinished = true;
            return;
        }
        Difficulty difficulty = getDifficulty(category);
        if (difficulty == null) {
            gameFinished = true;
            return;
        }
        gameManagement(category, difficulty, user);
    }

    public void gameManagement(Category category, Difficulty difficulty, User user) throws IOException, InterruptedException, SQLException {
        int roundScore = roundManager.startRound(category, difficulty);
        this.currentTotalScore += roundScore;
        // save the new score in the DB
        int userScore = db.updateScore(user, this.currentTotalScore);
        display.showTotalScore(userScore);
    }

    // TODO improve to a better implementation
    private Category getCategory() throws IllegalStateException {
        display.showMainMenu();
        int category = inputGetter.getIntFromUser(NUM_OF_CATEGORY_OPTIONS);
        return switch (category) {
            case 1 -> Category.GENERAL;
            case 2 -> Category.SPORTS;
            case 3 -> Category.GEOGRAPHY;
            case 4 -> Category.HISTORY;
            case 5 -> Category.ANIMALS;
            case 6 -> null;
            default -> throw new IllegalStateException("Unexpected value: " + category);
        };
    }

    // TODO improve to a better implementation
    private Difficulty getDifficulty(Category category) throws IllegalStateException {
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

    public void getScoreBoard() throws SQLException {
        display.scoreBoard(this.db.getTop10());
    }

    public User login() throws SQLException {
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
