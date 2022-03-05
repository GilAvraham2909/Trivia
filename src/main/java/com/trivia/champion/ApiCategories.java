package com.trivia.champion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiCategories extends Categories {
    private CategoriesApiParser categoriesApiParser = new CategoriesApiParser();
    private List<ApiCategory> apiCategories;
    private ArrayList<String> categories = new ArrayList<>();

    public ApiCategories() throws IOException, InterruptedException {
        apiCategories = categoriesApiParser.parse();
        for (ApiCategory apiCategory : apiCategories) {
            categories.add(apiCategory.getName());
        }
        super.setCategories(categories);
    }

    public int getCategoryId(String category) {
        for (ApiCategory apiCategory : apiCategories) {
            if (apiCategory.getName().equals(category))
                return apiCategory.getId();
        }
        return -1;
    }
}
