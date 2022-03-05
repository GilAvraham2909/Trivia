package com.trivia.champion;

import com.trivia.champion.enums.Category;
import com.trivia.champion.enums.Difficulty;

import java.io.IOException;

import static com.trivia.champion.utils.Constants.NUM_OF_OPTIONAL_ANSWERS;
import static com.trivia.champion.utils.Constants.NUM_OF_QUESTIONS;

public class RoundManager {
    private boolean roundFinished = false;
    private QuestionsManager questionsManager;
    private IPlayerUi display = PlayerConsole.getInstance();
    private InputGetter inputGetter = new InputGetter();

    public RoundManager() {}

    public int startRound(Category category, Difficulty difficulty) throws IOException, InterruptedException {
        questionsManager = new QuestionsManager(category, difficulty);
        RoundScoreFactory roundScoreFactory = new RoundScoreFactory();
        RoundScore score = roundScoreFactory.makeRoundScore(difficulty);
        // start asking the user questions, get answers and change score
        for (int i = 0; i < NUM_OF_QUESTIONS; i++) {
            Question question = questionsManager.nextQuestion();
            display.showQuestion(question);
            int answerNum = inputGetter.getIntFromUser(NUM_OF_OPTIONAL_ANSWERS);
            boolean correctAnswer = questionsManager.isCorrectAnswer(answerNum);
            if (correctAnswer) {
                score.addPoints();
                display.showCorrectAndScore(score.getScore());
            }
        }
        display.showTotalRoundScore(score.getScore());
        return score.getScore();
    }

}
