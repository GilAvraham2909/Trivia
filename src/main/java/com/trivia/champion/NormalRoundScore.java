package com.trivia.champion;

import static com.trivia.champion.utils.Constants.NORMAL_QUESTION_SCORE;

public class NormalRoundScore extends RoundScore {

    @Override
    public void addPoints() {
        int currentScore = getScore();
        setScore(currentScore + NORMAL_QUESTION_SCORE);
    }
}
