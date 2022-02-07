package com.trivia.champion;

import java.io.IOException;

public interface IParser {
    Object data = null;

    QuestionList parse() throws IOException, InterruptedException;

}
