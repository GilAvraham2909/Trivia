package com.trivia.champion.ui.input;

import com.trivia.champion.IInputGetter;

import java.util.InputMismatchException;

//NOT IMPLEMENTED
public class GuiInputGetter implements IInputGetter {
    @Override
    public int getIntFromUser(int endOfRange) throws InputMismatchException {
        return 0;
    }

    @Override
    public String getStringFromUser() {
        return null;
    }
}
