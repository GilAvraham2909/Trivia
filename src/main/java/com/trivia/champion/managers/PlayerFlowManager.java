package com.trivia.champion.managers;

import com.trivia.champion.*;
import com.trivia.champion.categories.Categories;
import com.trivia.champion.db.IDB;
import com.trivia.champion.db.SqliteAdapter;
import com.trivia.champion.db.SqliteDB;
import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.factories.GameModeFactory;
import com.trivia.champion.factories.UiFactory;
import com.trivia.champion.ui.input.IInputGetter;
import com.trivia.champion.ui.output.player.IPlayerUi;
import com.trivia.champion.users.Player;
import com.trivia.champion.users.User;

import java.util.List;

import static com.trivia.champion.utils.Constants.NUM_OF_DIFFICULTY_OPTIONS;

public class PlayerFlowManager extends FlowManager {
    private IDB db = new SqliteAdapter(new SqliteDB());
    public boolean quitGame = false;
    UiFactory uiFactory = UiFactory.getInstance();
    private IPlayerUi display = uiFactory.getPlayerUiOutput();
    private IInputGetter inputGetter = uiFactory.getUiInput();
    private RoundManager roundManager = new RoundManager();
    private int currentTotalScore;
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
                continue;
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
