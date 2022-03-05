package com.trivia.champion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputGetter {
    private final PlayerConsole console = PlayerConsole.getInstance();

    public int getIntFromUser(int endOfRange) throws InputMismatchException {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
                if (num > 0 && num <= endOfRange) {
                    return num;
                } else {
                    console.showInvalidRange(endOfRange);
                }
            } catch (InputMismatchException e) {
                console.showInvalidInput();
            }
        }
    }

    public String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
