package com.trivia.champion;

import java.io.IOException;

import static com.trivia.champion.utils.Constants.NUM_OF_QUESTIONS;

public class GameRoundManager {
    private boolean roundFinished = false;
    private QuestionsManager questionsManager;
    private IShow display;

    public GameRoundManager(IShow display) {
        this.display = display;
    }

    public int startGameRound(Category category, Difficulty difficulty) throws IOException, InterruptedException {
        questionsManager = new QuestionsManager(category, difficulty);
        RoundScoreFactory roundScoreFactory = new RoundScoreFactory();
        RoundScore score = roundScoreFactory.makeRoundScore(difficulty);
        // start asking the user questions, get answers and change score
        for (int i = 0; i < NUM_OF_QUESTIONS; i++) {
            Question question = questionsManager.nextQuestion();
            int answerNum = display.askQuestion(question);
            boolean correctAnswer = questionsManager.isCorrectAnswer(answerNum);
            if (correctAnswer) {
                System.out.println("\ncorrect!\n");
                score.addPoints();
                System.out.println("current round score is: " + score.getScore());
            }
        }
        System.out.println("TOTAL round score is: " + score.getScore());
        return score.getScore();
    }

}
