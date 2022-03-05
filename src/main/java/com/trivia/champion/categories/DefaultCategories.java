package com.trivia.champion.categories;

import java.util.ArrayList;

public class DefaultCategories extends Categories {
    private ArrayList<String> categories = new ArrayList<>();

    public DefaultCategories() {
        categories.add("General Knowledge");
        categories.add("Sports");
        categories.add("Geography");
        categories.add("History");
        categories.add("Animals");
        super.setCategories(categories);
    }

}
