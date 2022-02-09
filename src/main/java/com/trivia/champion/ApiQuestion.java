package com.trivia.champion;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ApiQuestion {
    private String category, type, difficulty, question, correct_answer;
    private List<String> incorrect_answers;

    public String getCategory() {
        return new String(Base64.getDecoder().decode(category), StandardCharsets.UTF_8);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return new String(Base64.getDecoder().decode(type), StandardCharsets.UTF_8);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return new String(Base64.getDecoder().decode(difficulty), StandardCharsets.UTF_8);
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return new String(Base64.getDecoder().decode(question), StandardCharsets.UTF_8);
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return new String(Base64.getDecoder().decode(correct_answer), StandardCharsets.UTF_8);
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<String> getIncorrect_answers() {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            list.add(new String(Base64.getDecoder().decode(incorrect_answers.get(i)), StandardCharsets.UTF_8));
        }
        return list;
    }

    public void setIncorrect_answers(List<String> incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }
}
