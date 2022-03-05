package com.trivia.champion;

import java.util.*;

public class PlayerConsole implements IPlayerUi {
    private static PlayerConsole single_instance = null;

    public PlayerConsole() {}

    public static PlayerConsole getInstance() {
        if (single_instance == null)
            single_instance = new PlayerConsole();
        return single_instance;
    }

    @Override
    public void showWelcomePage() {
        System.out.println("Welcome To TRIVIA CHAMPION!");
        System.out.println("-------------------------\n");
        System.out.println("1 - login");
        System.out.println("2 - register");
    }

    @Override
    public void askForUserName() {
        System.out.println("enter username:");
    }

    @Override
    public void askForUserPassword() {
        System.out.println("enter Password:");
    }

    @Override
    public void existingUser() {
        System.out.println("there is already a user with that username.");
        System.out.println("-------------------------\n");
        askForUserName();
    }

    @Override
    public void couldNotFindUser() {
        System.out.println("could not fine a user with that username.");
        System.out.println("-------------------------\n");
        System.out.println("1 - try again");
        System.out.println("2 - register now");
    }

    @Override
    public void incorrectPassword() {
        System.out.println("wrong password password, please try again.");
        System.out.println("-------------------------\n");
        askForUserPassword();
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
//        System.out.println("Welcome To TRIVIA CHAMPION!");
//        System.out.println("-------------------------\n");
//        System.out.println("Pick a category:");
//        System.out.println("-------------------------\n");
//        System.out.println("1 - General");
//        System.out.println("2 - Sports");
//        System.out.println("3 - Geography");
//        System.out.println("4 - History");
//        System.out.println("5 - Animals");
//        System.out.println("6 - Quit");
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
        System.out.println("Your TOTAL score is: " + totalScore);
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
    public void scoreBoard(List<User> top10Users) {
        // TODO: 04/03/2022  add implementation.
    }

    @Override
    public void showQuestion(Question question) {
        System.out.println(question.toString());
    }

    public void showInvalidRange(int endOfRange) {
        System.out.println("please enter a number between 1 to " + endOfRange);
    }

    public void showInvalidInput() {
        System.out.println("please enter a valid number.");
    }
}