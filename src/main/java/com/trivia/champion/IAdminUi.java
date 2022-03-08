package com.trivia.champion;

import java.util.ArrayList;
import java.util.List;

public interface IAdminUi {
    void greetUser(String userName);

    void showMainMenu(List<String> properties);

    void showProperty(String property, Enum currentProperty, Enum[] options);

    void showPropertyChanged(Enum selected);
}
