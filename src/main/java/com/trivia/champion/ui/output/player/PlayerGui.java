package com.trivia.champion.ui.output.player;

import com.trivia.champion.users.Player;
import com.trivia.champion.questions.Question;

import java.util.ArrayList;
import java.util.List;

// NOT IMPLEMENTED
public class PlayerGui implements IPlayerUi {
    private static PlayerGui single_instance = null;

    private PlayerGui() {}

    public static PlayerGui getInstance() {
        if (single_instance == null)
            single_instance = new PlayerGui();
        return single_instance;
    }

    @Override
    public void greetUser(String userName, int userScore) {

    }

    @Override
    public void showTotalScore(int totalScore) {

    }

    @Override
    public void showMainMenu(ArrayList<String> categories) {

    }

    @Override
    public void showDifficultyLevel(String category) {

    }

    @Override
    public void showQuestion(Question question) {

    }

    @Override
    public void showApiProblem() {

    }

    @Override
    public void showCorrectAndScore(int currentRoundScore) {

    }

    @Override
    public void showTotalRoundScore(int totalRoundScore) {

    }

    @Override
    public void scoreBoard(List<Player> top10Users, int myPlace) {

    }
}
