package com.trivia.champion;

import com.trivia.champion.enums.Category;

import java.util.List;
import java.util.Map;

public interface IPlayerUi {
    void showWelcomePage();

    void askForUserName();

    void askForUserPassword();

    void existingUser();

    void couldNotFindUser();

    void incorrectPassword();

    void greetUser(String userName, int userScore);

    void showTotalScore(int totalScore);

    void showMainMenu();

    void showDifficultyLevel(Category category);

    void showQuestion(Question question);

    void showCorrectAndScore(int currentRoundScore);

    void showTotalRoundScore(int totalRoundScore);

    void scoreBoard(List<User> top10Users);
}
