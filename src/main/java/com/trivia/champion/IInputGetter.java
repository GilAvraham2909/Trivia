package com.trivia.champion;

import java.util.InputMismatchException;

public interface IInputGetter {

    int getIntFromUser(int endOfRange) throws InputMismatchException;

    String getStringFromUser();
}
