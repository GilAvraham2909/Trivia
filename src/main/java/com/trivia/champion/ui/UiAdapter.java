package com.trivia.champion.ui;

import com.trivia.champion.*;
import com.trivia.champion.enums.UiTypes;
import com.trivia.champion.ui.input.ConsoleInputGetter;
import com.trivia.champion.ui.input.GuiInputGetter;
import com.trivia.champion.ui.output.PlayerConsole;
import com.trivia.champion.ui.output.PlayerGui;
import com.trivia.champion.ui.output.login.LoginConsole;
import com.trivia.champion.ui.output.login.LoginGui;

import java.io.IOException;
import java.util.Objects;

import static com.trivia.champion.utils.Constants.DEFAULT_UI_TYPE;
import static com.trivia.champion.utils.Constants.PROPERTY_UI_TYPE;

public class UiAdapter {
    private int uiType;
    private static UiAdapter single_instance = null;

    public UiAdapter() throws IOException {
        try {
            uiType = Integer.parseInt(Objects.requireNonNull(AppConfig.loadProperty(PROPERTY_UI_TYPE)));
        } catch (Exception e) {
            setUiTypeToDefault();
        }
    }

    public static UiAdapter getInstance() throws Exception {
        if (single_instance == null)
            single_instance = new UiAdapter();
        return single_instance;
    }

    public ILoginUi getLoginUiOutput() throws IOException {
        if (uiType == UiTypes.CONSOLE.ordinal())
            return new LoginConsole();
        else
            return new LoginGui();
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
