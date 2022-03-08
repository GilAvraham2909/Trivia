package com.trivia.champion.questions;

import com.trivia.champion.GameModeFactory;
import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.parsers.IQuestionsParser;

import java.io.IOException;

public class QuestionsManager {
    private String category;
    private Difficulty difficulty;
    private QuestionList questionsList;
    private IQuestionsParser parser;

    public QuestionsManager(String category, Difficulty difficulty) throws Exception {
        this.category = category;
        this.difficulty = difficulty;
        GameModeFactory gameModeFactory = GameModeFactory.getInstance();
        parser = gameModeFactory.getQuestionsParser(category, difficulty);
        questionsList = initializeQuestions();
    }

    public QuestionList initializeQuestions() throws IOException, InterruptedException {
        return parser.parse();
    }

    public Question nextQuestion() {
        return questionsList.nextQuestion();
    }

    public boolean isQuestionsListEmpty() {
        return questionsList.isEmpty();
    }

    public boolean isCorrectAnswer(int answerNum) {
        String answer = questionsList.currentQuestion().getMap().get(answerNum);
        return questionsList.currentQuestion().getCorrectAnswer().equals(answer);
    }

}
