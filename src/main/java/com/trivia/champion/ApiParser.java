package com.trivia.champion;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static com.trivia.champion.utils.Constants.NUM_OF_QUESTIONS;

public class ApiParser implements IParser {
    private static final String API_URL = "https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple";
    private HttpClient client;

    public ApiParser() {
        this.client = HttpClient.newHttpClient();
    }

    @Override
    public QuestionList parse() throws IOException, InterruptedException {
        QuestionList questionList = new QuestionList();
        ApiResponse apiResponse = getQuestions();
        for (int i = 0; i <NUM_OF_QUESTIONS; i++) {
            ApiQuestion apiQuestion = apiResponse.getResults().get(i);
            questionList.add(parseQuestion(i + 1, apiQuestion));
        }
        return questionList;
    }

    public Question parseQuestion(int questionNumber, ApiQuestion apiQuestion) {
        String question = apiQuestion.getQuestion();
        String correctAnswer = apiQuestion.getCorrect_answer();
        List<String> incorrectAnswers = apiQuestion.getIncorrect_answers();
        return new Question(questionNumber + ". " + question, correctAnswer, incorrectAnswers);
    }

    private ApiResponse getQuestions() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // parse json into questionList
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<>() {});
    }


}
