package com.trivia.champion.categories;

import java.util.ArrayList;

public class MockCategories extends Categories {
    private ArrayList<String> categories = new ArrayList<>();

    public MockCategories() {
        categories.add("General Knowledge");
        categories.add("Sports");
        categories.add("Geography");
        categories.add("History");
        categories.add("Animals");
        super.setCategories(categories);
    }

}
