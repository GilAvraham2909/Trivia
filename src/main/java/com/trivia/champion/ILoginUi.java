package com.trivia.champion;

public interface ILoginUi {
    void showWelcomePage();

    void askForUserName();

    void askForUserPassword();

    void existingUser();

    void couldNotFindUser();

    void incorrectPassword();
}
