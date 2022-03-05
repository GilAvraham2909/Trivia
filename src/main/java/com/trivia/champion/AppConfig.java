package com.trivia.champion;

import java.util.Arrays;

import static com.trivia.champion.utils.Constants.CATEGORY_TYPES;

public class AppConfig {
    public String categoriesType = CATEGORY_TYPES[indexOf(CATEGORY_TYPES, "api")];
    public static int numOfCategoryOptions = 0;





    public static <T> int indexOf(T[] arr, T val) {
        return Arrays.asList(arr).indexOf(val);
    }

}
