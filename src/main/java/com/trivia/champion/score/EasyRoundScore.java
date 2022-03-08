package com.trivia.champion.score;

import static com.trivia.champion.utils.Constants.*;
public class EasyRoundScore extends RoundScore {

    @Override
    public void addPoints() {
        int currentScore = getScore();
        setScore(currentScore + EASY_QUESTION_SCORE);
    }
}
