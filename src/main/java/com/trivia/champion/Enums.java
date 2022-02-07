package com.trivia.champion;

enum Category {
    General,
    Science,
    Geography,
    Entertainment
}

enum Difficulty {
    Easy("Easy", 1),
    Normal("Normal", 2),
    Hard("Hard", 3);

    private final String diffString;
    private final int diffInt;

    Difficulty(String diffString, int diffInt) {
        this.diffInt = diffInt;
        this.diffString = diffString;
    }

    public String getDiffString() {
        return diffString;
    }

    public int getDiffInt() {
        return diffInt;
    }

}