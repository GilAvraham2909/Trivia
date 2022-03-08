package com.trivia.champion.ui.input;

import java.util.InputMismatchException;

public interface IInputGetter {

    int getIntFromUser(int endOfRange) throws InputMismatchException;

    String getStringFromUser();
}
