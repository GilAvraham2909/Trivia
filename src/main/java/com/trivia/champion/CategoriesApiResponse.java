package com.trivia.champion;

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
