package com.trivia.champion;

import java.util.Map;

public interface IShow {
    Map<String, String> login();

    int mainMenu();

    int difficultyLevel(Category category);

    int askQuestion(Question question);
}
