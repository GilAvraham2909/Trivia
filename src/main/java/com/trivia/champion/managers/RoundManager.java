package com.trivia.champion.managers;

import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.questions.Question;
import com.trivia.champion.score.RoundScore;
import com.trivia.champion.factories.RoundScoreFactory;
import com.trivia.champion.factories.UiFactory;
import com.trivia.champion.ui.input.IInputGetter;
import com.trivia.champion.ui.output.player.IPlayerUi;
import com.trivia.champion.ui.output.player.PlayerConsole;

import static com.trivia.champion.utils.Constants.NUM_OF_OPTIONAL_ANSWERS;
import static com.trivia.champion.utils.Constants.NUM_OF_QUESTIONS;

public class RoundManager {
    private final IPlayerUi display = PlayerConsole.getInstance();
    private final UiFactory uiFactory = UiFactory.getInstance();
    private final IInputGetter inputGetter = uiFactory.getUiInput();

    public RoundManager() throws Exception {}

    public int startRound(String category, Difficulty difficulty) throws Exception {
        QuestionsManager questionsManager = new QuestionsManager(category, difficulty);
        if (questionsManager.isQuestionsListEmpty()) {
            return 0;
        }
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
