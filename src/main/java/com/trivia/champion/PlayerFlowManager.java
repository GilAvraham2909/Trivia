package com.trivia.champion;

import com.trivia.champion.categories.Categories;
import com.trivia.champion.db.DbAdapter;
import com.trivia.champion.db.IDB;
import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.ui.UiAdapter;

import java.io.IOException;
import java.util.List;

import static com.trivia.champion.utils.Constants.NUM_OF_DIFFICULTY_OPTIONS;

public class PlayerFlowManager extends FlowManager {
    public boolean quitGame = false;
    UiAdapter uiAdapter = UiAdapter.getInstance();
    private IPlayerUi display = uiAdapter.getPlayerUiOutput();
    private IInputGetter inputGetter = uiAdapter.getUiInput();
    private RoundManager roundManager = new RoundManager();
    private int currentTotalScore;
    private DbAdapter dbAdapter = DbAdapter.getInstance();
    private IDB db = dbAdapter.getDb();
    private Player player;

    public PlayerFlowManager(User user) throws Exception {
        super(user);
        this.player = (Player) user;
    }

    public void start() throws Exception {
        player.setScore(db.getPlayerScore(player.getName()));
        display.greetUser(player.getName(), player.getScore());

        while (!quitGame) {
            String category = getCategory();
            if (category == null) {
                quitGame = true;
                db.closeConnection();
                return;
            }
            Difficulty difficulty = getDifficulty(category);
            if (difficulty == null) {
                quitGame = true;
                db.closeConnection();
                return;
            }
            gameManagement(category, difficulty, player);
        }
    }


    public void gameManagement(String category, Difficulty difficulty, Player player) throws Exception {
        int roundScore = roundManager.startRound(category, difficulty);
        this.currentTotalScore += roundScore;
        // save the new score in the DB
        int userScore = db.updateScore(player, this.currentTotalScore);
        display.showTotalScore(userScore);
        getScoreBoard();
    }

    private String getCategory() throws Exception {
        GameModeFactory gameModeFactory = GameModeFactory.getInstance();
        Categories categories = gameModeFactory.getCategoriesType();
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
        List<Player> playerList = this.db.scoreBoard();
        display.scoreBoard(playerList, this.player.playerPlace(playerList));
    }

}
