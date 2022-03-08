package com.trivia.champion.score;

public abstract class RoundScore {
    private int score;

    public RoundScore() {
        this.score = 0;
    }

    public abstract void addPoints();

    public void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
