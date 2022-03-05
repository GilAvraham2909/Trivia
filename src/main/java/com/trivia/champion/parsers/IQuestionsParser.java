package com.trivia.champion.parsers;

import com.trivia.champion.QuestionList;

import java.io.IOException;

public interface IQuestionsParser {
    Object data = null;

    QuestionList parse() throws IOException, InterruptedException;

}
