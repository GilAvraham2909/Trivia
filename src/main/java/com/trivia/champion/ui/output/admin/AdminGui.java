package com.trivia.champion.ui.output.admin;

import com.trivia.champion.IAdminUi;

import java.util.List;

// NOT IMPLEMENTED
public class AdminGui implements IAdminUi {
    private static AdminGui single_instance = null;

    private AdminGui() {}

    public static AdminGui getInstance() {
        if (single_instance == null)
            single_instance = new AdminGui();
        return single_instance;
    }


    @Override
    public void greetUser(String userName) {

    }

    @Override
    public void showMainMenu(List<String> categories) {

    }

    @Override
    public void showProperty(String property,  Enum currentProperty, Enum[] options) {

    }

    @Override
    public void showPropertyChanged(Enum selected) {

    }
}
