package com.trivia.champion.ui.output;

import com.trivia.champion.IPlayerUi;
import com.trivia.champion.Player;
import com.trivia.champion.questions.Question;
import com.trivia.champion.User;

import java.util.*;

public class PlayerConsole implements IPlayerUi {
    private static PlayerConsole single_instance = null;

    public PlayerConsole() {
    }

    public static PlayerConsole getInstance() {
        if (single_instance == null)
            single_instance = new PlayerConsole();
        return single_instance;
    }

    @Override
    public void greetUser(String userName, int userScore) {
        System.out.println("Hi " + userName + "! CURRENT score is: " + userScore);
    }

    @Override
    public void showMainMenu(ArrayList<String> categories) {
        System.out.println("Welcome To TRIVIA CHAMPION!");
        System.out.println("-------------------------\n");
        System.out.println("Pick a category:");
        System.out.println("-------------------------\n");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(i + 1 + " - " + categories.get(i));
        }
        System.out.println(categories.size() + 1 + " - " + "Quit");
    }

    @Override
    public void showDifficultyLevel(String category) {
        System.out.println("Category: " + category);
        System.out.println("-------------------------\n");
        System.out.println("Pick a difficulty level:");
        System.out.println("-------------------------\n");
        System.out.println("1 - Easy");
        System.out.println("2 - Normal");
        System.out.println("3 - Hard");
        System.out.println("4 - Back to Main Menu");
    }

    @Override
    public void showTotalScore(int totalScore) {
        System.out.println("Your TOTAL score is: " + totalScore + "\n");
    }

    @Override
    public void showCorrectAndScore(int currentRoundScore) {
        System.out.println("\ncorrect!\n");
        System.out.println("current round score is: " + currentRoundScore);
    }

    @Override
    public void showTotalRoundScore(int totalRoundScore) {
        System.out.println("TOTAL round score is: " + totalRoundScore);
    }

    @Override
    public void scoreBoard(List<Player> usersList, int myPlace) {
        System.out.println("Your Place is: " + myPlace + "\n");
        System.out.println("-------------------------\n");
        System.out.println("TOP 10:");
        int i = 1;
        for (Player player : usersList) {
            System.out.println((i) + " place: " + player.getName() + " with " + player.getScore());
            i++;
        }
        System.out.println("-------------------------\n");
    }

    @Override
    public void showQuestion(Question question) {
        System.out.println(question.toString());
    }

    @Override
    public void showApiProblem() {
        System.out.println("There is a problem with the server - please try another category-difficulty combination.");
    }

    public void showInvalidRange(int endOfRange) {
        System.out.println("please enter a number between 1 to " + endOfRange);
    }

    public void showInvalidInput() {
        System.out.println("please enter a valid number.");
    }
}
