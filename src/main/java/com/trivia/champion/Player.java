package com.trivia.champion;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Player extends User {
    private int score;

    public Player(String name, String password, String type) {
        super(name, password, type);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int playerPlace(@NotNull List<Player> playerList) {
        int i = 1;
        for (Player player : playerList) {
            if (player.getName().equals(this.getName()))
                break;
            i++;
        }
        return i;
    }
}
