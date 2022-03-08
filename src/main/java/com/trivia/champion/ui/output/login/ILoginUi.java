package com.trivia.champion.ui.output.login;

public interface ILoginUi {
    void showWelcomePage();

    void askForUserName();

    void askForUserPassword();

    void existingUser();

    void couldNotFindUser();

    void incorrectPassword();
}
