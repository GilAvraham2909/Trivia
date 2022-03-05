package com.trivia.champion.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionList {
    private List<Question> questionList;
    private int currentIndex;
    private Iterator<Question> iterator = null;


    public QuestionList() {
        questionList = new ArrayList<>();
        currentIndex = 0;
    }

    public boolean isEmpty() {
        return questionList.size() == 0;
    }

    public void add(Question question) {
        questionList.add(question);
    }

    public void remove(int index) {
        questionList.remove(index);
    }

    public Question get(int index) {
        return questionList.get(index);
    }

    public Question nextQuestion() {
        if (iterator == null)
            iterator = questionList.iterator();
        currentIndex += 1;
        return iterator.next();
    }

    public Question currentQuestion() {
        return questionList.get(currentIndex - 1);
    }


}
