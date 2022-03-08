package com.trivia.champion;

import com.trivia.champion.enums.GameModes;
import com.trivia.champion.enums.UiTypes;
import com.trivia.champion.ui.UiFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.trivia.champion.utils.Constants.*;

public class AdminFlowManager extends FlowManager{
    public boolean quitGame = false;
    UiFactory uiFactory = UiFactory.getInstance();
    private IAdminUi display = uiFactory.getAdminUiOutput();
    private IInputGetter inputGetter = uiFactory.getUiInput();
    private Admin admin;

    public AdminFlowManager(User user) throws Exception {
        super(user);
        this.admin = (Admin) user;
    }

    @Override
    public void start() throws Exception {
        display.greetUser(admin.getName());
        while (!quitGame) {
            String property = getProperty();
            if (property == null) {
                quitGame = true;
                return;
            }
            changeProperty(property);
        }
    }

    private String getProperty() {
        List<String> propertyList = new ArrayList<>();
        Iterator<Object> it = AppConfig.props.keys().asIterator();
        for (int i = 0; i < AppConfig.props.size(); i++) {
            propertyList.add(it.next().toString());
        }
        display.showMainMenu(propertyList);
        int propertyIndex = inputGetter.getIntFromUser(propertyList.size() + 1);
        if(propertyIndex > propertyList.size()) {
            return null;
        }
        return propertyList.get(propertyIndex - 1);
    }

    private void changeProperty(String property) throws IOException {
        int currentPropertyIndex = Integer.parseInt(AppConfig.props.getProperty(property));
        Enum currentProperty = getCurrentProperty(property, currentPropertyIndex);
        Enum[] options = getPropertyOptions(property);
        display.showProperty(property, currentProperty, options);
        int newIndex = inputGetter.getIntFromUser(options.length);
        Integer newIndex1 = newIndex - 1;
        AppConfig.setProperty(property,newIndex1.toString());
        display.showPropertyChanged(options[newIndex - 1]);
    }

    private Enum getCurrentProperty(String property, int num) {
        switch (property) {
            case PROPERTY_UI_TYPE -> {
                return UiTypes.values()[num];
            }
            case PROPERTY_GAME_MODE -> {
                return GameModes.values()[num];
            }
        }
        return null;
    }

    private Enum[] getPropertyOptions(String property) {
        switch (property) {
            case PROPERTY_UI_TYPE -> {
                return UiTypes.values();
            }
            case PROPERTY_GAME_MODE -> {
                return GameModes.values();
            }
        }
        return null;
    }
}
