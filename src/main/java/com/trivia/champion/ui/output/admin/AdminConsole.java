package com.trivia.champion.ui.output.admin;

import com.trivia.champion.IAdminUi;


import java.util.List;

public class AdminConsole implements IAdminUi {
    private static AdminConsole single_instance = null;

    private AdminConsole() {
    }

    public static AdminConsole getInstance() {
        if (single_instance == null)
            single_instance = new AdminConsole();
        return single_instance;
    }

    @Override
    public void greetUser(String userName) {
        System.out.println("Hello " + userName + ". Welcome to the Admin console.");
    }

    @Override
    public void showMainMenu(List<String> properties) {
        System.out.println("Please pick a property to set");
        System.out.println("-------------------------\n");
        for (int i = 0; i < properties.size(); i++) {
            System.out.println(i + 1 + ". " + properties.get(i));
        }
        System.out.println(properties.size() + 1 + ". Quit");
    }

    @Override
    public void showProperty(String property, Enum currentProperty, Enum[] options) {
        System.out.println("Property: " + property);
        System.out.println("Current property is : " + currentProperty.name());
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + ". " + options[i]);
        }



    }

    @Override
    public void showPropertyChanged(Enum selected) {
        System.out.println(selected.name() + " is now set!");
    }
}
