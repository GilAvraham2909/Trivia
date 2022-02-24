package com.trivia.champion;

import static com.trivia.champion.utils.Constants.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

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
        System.out.println("5 - Celebrities");
        System.out.println("6 - Quit");
        return getIntFromUser(NUM_OF_MAIN_MENU_OPTIONS);
    }

    @Override
    public Map<String, String> login() {
        Map<String, String> nameMap = new HashMap<String, String>();
        System.out.println("Welcome To TRIVIA CHAMPION!");
        System.out.println("-------------------------\n");
        System.out.println("Enter your user name & password:");
        System.out.println("Note: if you do not have a user it will create one.");
        System.out.println("-------------------------\n");
        System.out.println("user:");
        nameMap.put("userName", getStringFromUser());
        System.out.println("password:");
        nameMap.put("userPassword", getStringFromUser());
        return nameMap;
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
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            return name;
        }
    }

}
