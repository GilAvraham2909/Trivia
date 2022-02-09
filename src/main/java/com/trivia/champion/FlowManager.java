package com.trivia.champion;

import java.io.IOException;

// singleton class
public class FlowManager {
    public boolean gameFinished = false;
    private IShow display = new Console();
    private GameRoundManager gameRoundManager = new GameRoundManager(display);
    private int currentTotalScore;

    private static FlowManager single_instance = null;

    private FlowManager() {}

    public static FlowManager getInstance() {
        if (single_instance == null)
            single_instance = new FlowManager();
        return single_instance;
    }

    public void start() throws IOException, InterruptedException {
        //TODO get currentTotalScore here
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
        gameManagement(category, difficulty);
    }

    public void gameManagement(Category category, Difficulty difficulty) throws IOException, InterruptedException {
        int roundScore = gameRoundManager.startGameRound(category, difficulty);
        this.currentTotalScore += roundScore;
        // TODO save the new score in the DB.
    }

    // TODO improve to a better implementation
    private Category getCategory() throws IllegalStateException {
        int category = display.mainMenu();
        return switch (category) {
            case 1 -> Category.GENERAL;
            case 2 -> Category.SPORTS;
            case 3 -> Category.GEOGRAPHY;
            case 4 -> Category.HISTORY;
            case 5 -> Category.CELEBRITIES;
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

    public void getScoreBoard() {
        // TODO get the scoreboard from the ScoreboardReader
    }
}
