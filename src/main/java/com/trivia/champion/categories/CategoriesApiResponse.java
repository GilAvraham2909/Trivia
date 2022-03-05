package com.trivia.champion.categories;

import com.trivia.champion.categories.ApiCategory;

import java.util.List;

public class CategoriesApiResponse {
    private List<ApiCategory> trivia_categories;

    public List<ApiCategory> getTrivia_categories() {
        return trivia_categories;
    }

    public void setTrivia_categories(List<ApiCategory> trivia_categories) {
        this.trivia_categories = trivia_categories;
    }
}
