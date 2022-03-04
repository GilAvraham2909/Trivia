package com.trivia.champion;

import com.trivia.champion.enums.Category;
import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.parsers.ApiParser;
import com.trivia.champion.parsers.IParser;

import java.io.IOException;

public class QuestionsManager {
    private Category category;
    private Difficulty difficulty;
    private QuestionList questionsList;
//    private IParser parser = new MockParser();
    private IParser parser;

    public QuestionsManager(Category category, Difficulty difficulty) throws IOException, InterruptedException {
        this.category = category;
        this.difficulty = difficulty;
        parser = new ApiParser(category, difficulty);
        questionsList = initializeQuestions();
    }

    public QuestionList initializeQuestions() throws IOException, InterruptedException {
        return parser.parse();
    }

    public Question nextQuestion() {
        return questionsList.nextQuestion();
    }

    public boolean isCorrectAnswer(int answerNum) {
        String answer = questionsList.currentQuestion().getMap().get(answerNum);
        return questionsList.currentQuestion().getCorrectAnswer().equals(answer);
    }

}
