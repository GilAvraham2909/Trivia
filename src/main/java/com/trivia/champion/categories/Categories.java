package com.trivia.champion.categories;

import com.trivia.champion.AppConfig;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Categories {
    private ArrayList<String> categories;

    public Categories() {
        this.categories = new ArrayList<>();
    }

    public ArrayList<String> getCategories() {
        AppConfig.numOfCategoryOptions = categories.size() + 1;
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getCategory(int index) {
        if (index >= 1 && index <= categories.size())
            return categories.get(index - 1);
        return null;
    }
}
