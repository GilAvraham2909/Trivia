package com.trivia.champion;

import java.util.ArrayList;
import java.util.List;
import static com.trivia.champion.utils.Constants.*;

public class MockParser implements IParser{
    private List<String> incorrectAnswers = new ArrayList<>();
    private QuestionList questionList = new QuestionList();
    private String question, correctAnswer;

    @Override
    public QuestionList parse() {
        incorrectAnswers.add("bad answer 1");
        incorrectAnswers.add("bad answer 2");
        incorrectAnswers.add("bad answer 3");
        correctAnswer = "correct answer";
        for (int i = 1; i <= NUM_OF_QUESTIONS; i++) {
            questionList.add(new Question("question " + i, correctAnswer, incorrectAnswers));
        }
        return questionList;
    }

}
