package com.trivia.champion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.trivia.champion.utils.Constants.NUM_OF_OPTIONAL_ANSWERS;

public class Question {
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;
    private Map<Integer, String> map = new HashMap();

    public Question(String question, String correctAnswer, List<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
        createMap();
    }

    private void createMap() {
        int min = 1;
        Random random = new Random();
        int correctIndex = min + random.nextInt(4);
        map.put(correctIndex, correctAnswer);
        for (int i = 1; i < correctIndex; i++) {
            map.put(i, incorrectAnswers.get(i - 1));
        }
        for (int i = correctIndex + 1; i < 5; i++) {
            map.put(i, incorrectAnswers.get(i - 2));
        }
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public String toString() {
        String head = "\n" + question;
        String underline = "\n-------------------------";
        StringBuilder answers = new StringBuilder();
        for (int i = 1; i <= NUM_OF_OPTIONAL_ANSWERS; i++) {
            answers.append("\n").append(i).append(". ").append(map.get(i));
        }
        return head + underline + answers;
    }

}
