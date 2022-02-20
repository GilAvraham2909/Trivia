package com.trivia.champion;

import static com.trivia.champion.utils.Constants.*;
public class EasyRoundScore extends RoundScore {

    @Override
    public void addPoints() {
        int currentScore = getScore();
        setScore(currentScore + EASY_QUESTION_SCORE);
    }
}
