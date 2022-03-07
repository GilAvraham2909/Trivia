package com.trivia.champion.ui.input;

import com.trivia.champion.IInputGetter;
import com.trivia.champion.ui.output.player.PlayerConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputGetter implements IInputGetter {
    private final PlayerConsole console = PlayerConsole.getInstance();

    @Override
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

    @Override
    public String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
