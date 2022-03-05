package com.trivia.champion.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Constants  {
    public static final int NUM_OF_USER_TYPES = 2;
    public static final int NUM_OF_WELCOME_PAGE_OPTIONS = 2;
    public static final int NUM_OF_DIFFICULTY_OPTIONS = 5;
    public static final int NUM_OF_QUESTIONS = 10;
    public static final int NUM_OF_OPTIONAL_ANSWERS = 4;
    public static final int EASY_QUESTION_SCORE = 10;
    public static final int NORMAL_QUESTION_SCORE = 20;
    public static final int HARD_QUESTION_SCORE = 30;
    public static final String QUESTIONS_API_PREFIX = "https://opentdb.com/api.php?";
    public static final String QUESTIONS_API_SUFFIX = "type=multiple&encode=base64";
    public static final String CATEGORIES_API = "https://opentdb.com/api_category.php";
    public static final String[] CATEGORY_TYPES = {"default", "api", "file"};
    public static final String[] UI_TYPES = {"console", "gui"};


}