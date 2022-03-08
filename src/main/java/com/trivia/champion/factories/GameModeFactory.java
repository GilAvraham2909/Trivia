package com.trivia.champion.factories;

import com.trivia.champion.AppConfig;
import com.trivia.champion.categories.ApiCategories;
import com.trivia.champion.categories.Categories;
import com.trivia.champion.categories.MockCategories;
import com.trivia.champion.categories.FileCategories;
import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.enums.GameModes;
import com.trivia.champion.parsers.ApiQuestionsParser;
import com.trivia.champion.parsers.FileQuestionsParser;
import com.trivia.champion.parsers.IQuestionsParser;
import com.trivia.champion.parsers.MockQuestionsParser;

import java.io.IOException;
import java.util.Objects;

import static com.trivia.champion.utils.Constants.*;

public class GameModeFactory {
    private int gameMode;
    private static GameModeFactory single_instance = null;

    private GameModeFactory() throws IOException {
        try {
            gameMode = Integer.parseInt(Objects.requireNonNull(AppConfig.loadProperty(PROPERTY_GAME_MODE)));
        } catch (Exception e) {
            setGameModeToDefault();
        }
    }

    public static GameModeFactory getInstance() throws Exception {
        if (single_instance == null)
            single_instance = new GameModeFactory();
        return single_instance;
    }

    public Categories getCategoriesType() throws Exception {
        if (gameMode == GameModes.API.ordinal())
            return new ApiCategories();
        else if(gameMode == GameModes.FILE.ordinal()) {
            return new FileCategories();
        } else{
            return new MockCategories();
        }
    }

    public IQuestionsParser getQuestionsParser(String category, Difficulty difficulty) {
        if (gameMode == GameModes.API.ordinal())
            return new ApiQuestionsParser(category, difficulty);
        else if(gameMode == GameModes.FILE.ordinal()) {
            return new FileQuestionsParser(category, difficulty);
        } else{
            return new MockQuestionsParser();
        }
    }


    private void setGameModeToDefault() throws IOException {
        AppConfig.setProperty(PROPERTY_GAME_MODE, DEFAULT_GAME_MODE.toString());
    }
}
