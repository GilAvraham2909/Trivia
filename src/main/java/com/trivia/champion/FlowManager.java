package com.trivia.champion;

import com.trivia.champion.db.SqliteDB;
import com.trivia.champion.enums.Category;
import com.trivia.champion.enums.Difficulty;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

// singleton class
public class FlowManager {
    public boolean gameFinished = false;
    //new UiAdapter

    //TODO private IShow display = uiAdapter(CONSOLE);
    private IShow display = new Console();
    private RoundManager roundManager = new RoundManager(display);
    private int currentTotalScore;
    private SqliteDB db = new SqliteDB();

    private static FlowManager single_instance = null;

    private FlowManager() throws SQLException {
    }

    public static FlowManager getInstance() throws SQLException {
        if (single_instance == null)
            single_instance = new FlowManager();
        return single_instance;
    }

    public void start() throws IOException, InterruptedException, SQLException {
        User user = login();
        System.out.println("Hi " + user.getName() + " CURRENT score is: " + user.getScore());
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
        System.out.println("Your'e TOTAL score is: " + userScore);
    }

    // TODO improve to a better implementation
    private Category getCategory() throws IllegalStateException {
        int category = display.mainMenu();
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
        return switch (display.difficultyLevel(category)) {
            case 1 -> Difficulty.Easy;
            case 2 -> Difficulty.Normal;
            case 3 -> Difficulty.Hard;
            case 4 -> null;
            default -> throw new IllegalStateException("Unexpected value: " + display.difficultyLevel(category));
        };
    }

    public void getScoreBoard() throws SQLException {
        display.scoreBord(this.db.getTop10());
    }

    public User login() throws SQLException {
        int userType = display.welcomePage();
        User user = null;
        switch (userType) {
            case 1: {
                while (user == null) {
                    String registeredUsername = display.getUserName();
                    user = this.db.getUserFromDB(registeredUsername);
                    if (user != null) {
                        break;
                    }
                    userType = display.couldNotFindUser();
                    if (userType == 2) {
                        break;
                    }
                }
                if (user != null) {
                    String registeredPassword = display.getUserPassword();
                    while (!this.db.validateUser(user, registeredPassword)) {
                        display.incorrectPassword();
                        registeredPassword = display.getUserPassword();
                    }
                    return user;
                }
            }
            case 2: {
                String newUsername = display.getUserName();
                while (this.db.getUserFromDB(newUsername) != null) {
                    display.existingUser();
                    newUsername = display.getUserName();
                }
                String newPassword = display.getUserPassword();
                user = this.db.addToDB(newUsername, newPassword);
                break;
            }
        }
        return user;
    }
}
