package com.trivia.champion.ui.output.login;

public class LoginConsole implements ILoginUi {

    @Override
    public void showWelcomePage() {
        System.out.println("Welcome To TRIVIA CHAMPION!");
        System.out.println("-------------------------\n");
        System.out.println("1 - login");
        System.out.println("2 - register");
    }

    @Override
    public void askForUserName() {
        System.out.println("enter username:");
    }

    @Override
    public void askForUserPassword() {
        System.out.println("enter Password:");
    }

    @Override
    public void existingUser() {
        System.out.println("there is already a user with that username.");
        System.out.println("-------------------------\n");
        askForUserName();
    }

    @Override
    public void couldNotFindUser() {
        System.out.println("could not fine a user with that username.");
        System.out.println("-------------------------\n");
        System.out.println("1 - try again");
        System.out.println("2 - register now");
    }

    @Override
    public void incorrectPassword() {
        System.out.println("wrong password password, please try again.");
        System.out.println("-------------------------\n");
        askForUserPassword();
    }
}
