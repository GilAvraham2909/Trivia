package com.trivia.champion;

import com.trivia.champion.enums.Category;

import java.util.List;
import java.util.Map;

public interface IShow {
    int welcomePage();

    String getUserName();

    String getUserPassword();

    void existingUser();

    int couldNotFindUser();

    void incorrectPassword();

    int mainMenu();

    int difficultyLevel(Category category);

    int askQuestion(Question question);

    void scoreBord(List<User> top10Users);
}
