package com.trivia.champion.factories;

import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.score.EasyRoundScore;
import com.trivia.champion.score.HardRoundScore;
import com.trivia.champion.score.NormalRoundScore;
import com.trivia.champion.score.RoundScore;

public class RoundScoreFactory {

    public RoundScore makeRoundScore(Difficulty difficulty) {
        switch (difficulty) {
            case Easy -> { return new EasyRoundScore(); }
            case Normal -> { return new NormalRoundScore(); }
            case Hard -> { return new HardRoundScore(); }
            default -> { return null; }
        }
    }
}
