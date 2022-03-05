package com.trivia.champion.ui;

import com.trivia.champion.AppConfig;
import com.trivia.champion.IInputGetter;
import com.trivia.champion.IPlayerUi;
import com.trivia.champion.enums.UiTypes;
import com.trivia.champion.ui.input.ConsoleInputGetter;
import com.trivia.champion.ui.input.GuiInputGetter;
import com.trivia.champion.ui.output.PlayerConsole;
import com.trivia.champion.ui.output.PlayerGui;

import java.io.IOException;
import java.util.Objects;

import static com.trivia.champion.utils.Constants.DEFAULT_UI_TYPE;
import static com.trivia.champion.utils.Constants.PROPERTY_UI_TYPE;

public class UiAdapter {
    private int uiType;

    public UiAdapter() throws IOException {
        try {
            uiType = Integer.parseInt(Objects.requireNonNull(AppConfig.loadProperty(PROPERTY_UI_TYPE)));
        } catch (Exception e) {
            setUiTypeToDefault();
        }
    }

    public IPlayerUi getUiOutput() throws IOException {
        if (uiType == UiTypes.CONSOLE.ordinal())
            return new PlayerConsole();
        else
            return new PlayerGui();
    }

    public IInputGetter getUiInput() throws IOException {
        if (uiType == UiTypes.CONSOLE.ordinal())
            return new ConsoleInputGetter();
        else
            return new GuiInputGetter();
    }

    private void setUiTypeToDefault() throws IOException {
        AppConfig.setProperty(PROPERTY_UI_TYPE, DEFAULT_UI_TYPE.toString());
    }
}
