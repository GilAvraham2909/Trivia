package com.trivia.champion;

import com.trivia.champion.enums.Category;

import static com.trivia.champion.utils.Constants.*;

import java.util.*;

public class Console implements IShow {

    @Override
    public int mainMenu() {
        System.out.println("Welcome To TRIVIA CHAMPION!");
        System.out.println("-------------------------\n");
        System.out.println("Pick a category:");
        System.out.println("-------------------------\n");
        System.out.println("1 - General");
        System.out.println("2 - Sports");
        System.out.println("3 - Geography");
        System.out.println("4 - History");
        System.out.println("5 - Animals");
        System.out.println("6 - Quit");
        return getIntFromUser(NUM_OF_MAIN_MENU_OPTIONS);
    }
    @Override
    public int welcomePage(){
        System.out.println("Welcome To TRIVIA CHAMPION!");
        System.out.println("-------------------------\n");
        System.out.println("1 - login");
        System.out.println("2 - register");
        return getIntFromUser(2);
    }

    @Override
    public String getUserName(){
        System.out.println("enter username:");
        return getStringFromUser();

    }

    @Override
    public String getUserPassword(){
        System.out.println("enter Password:");
        return getStringFromUser();
    }

    @Override
    public void existingUser(){
        System.out.println("there is a user with that username.");
        System.out.println("-------------------------\n");
    }

    @Override
    public int couldNotFindUser(){
        System.out.println("could not fine a user with that username.");
        System.out.println("-------------------------\n");
        System.out.println("1 - try again");
        System.out.println("2 - register now");
        return getIntFromUser(2);
    }

    @Override
    public void incorrectPassword(){
        System.out.println("wrong password password, please try again.");
        System.out.println("-------------------------\n");
    }

    @Override
    public void scoreBord(List<User> top10Users){
        // TODO: 04/03/2022  add implementation.
    }

    @Override
    public int difficultyLevel(Category category) {
        System.out.println("Category: " + category.toString());
        System.out.println("-------------------------\n");
        System.out.println("Pick a difficulty level:");
        System.out.println("-------------------------\n");
        System.out.println("1 - Easy");
        System.out.println("2 - Normal");
        System.out.println("3 - Hard");
        System.out.println("4 - Back to Main Menu");
        return getIntFromUser(NUM_OF_CATEGORY_OPTIONS);
    }

    @Override
    public int askQuestion(Question question) {
        System.out.println(question.toString());
        return getIntFromUser(NUM_OF_OPTIONAL_ANSWERS);
    }

    public int getIntFromUser(int endOfRange) throws InputMismatchException {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
                if (num > 0 && num <= endOfRange) {
                    return num;
                } else {
                    System.out.println("please enter a number between 1 to " + endOfRange);
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a valid number.");
            }
        }
    }

    public String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();

    }

}
