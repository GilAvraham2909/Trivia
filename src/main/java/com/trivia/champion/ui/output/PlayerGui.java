package com.trivia.champion.ui.output;

import com.trivia.champion.IPlayerUi;
import com.trivia.champion.questions.Question;
import com.trivia.champion.User;

import java.util.ArrayList;
import java.util.List;

// NOT IMPLEMENTED
public class PlayerGui implements IPlayerUi {
    private static PlayerGui single_instance = null;

    public PlayerGui() {}

    public static PlayerGui getInstance() {
        if (single_instance == null)
            single_instance = new PlayerGui();
        return single_instance;
    }

    @Override
    public void showWelcomePage() {

    }

    @Override
    public void askForUserName() {

    }

    @Override
    public void askForUserPassword() {

    }

    @Override
    public void existingUser() {

    }

    @Override
    public void couldNotFindUser() {

    }

    @Override
    public void incorrectPassword() {

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
    public void scoreBoard(List<User> top10Users, int myPlace) {

    }
}
