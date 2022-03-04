package com.trivia.champion;

import com.trivia.champion.enums.Category;

import java.util.Map;

public interface IShow {
    Map<String, String> login();

    int mainMenu();

    int difficultyLevel(Category category);

    int askQuestion(Question question);
}
