package com.trivia.champion;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.trivia.champion.utils.Constants.*;

public class ApiParser implements IParser {
    private HttpClient client;
    private Category category;
    private Difficulty difficulty;

    public ApiParser(Category category, Difficulty difficulty) {
        this.client = HttpClient.newHttpClient();
        this.category = category;
        this.difficulty = difficulty;
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
                .uri(URI.create(createApiRequest()))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // parse json into questionList
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<>() {});
    }

    private String createApiRequest() {
        String amount = "amount=" + NUM_OF_QUESTIONS + "&";
        String category = "category=" + getApiCategory() + "&";
        String difficulty = "difficulty=" + getApiDifficulty() + "&";
        return API_PREFIX + amount + category + difficulty + API_SUFFIX;
    }

    private String getApiCategory() {
        return switch (category) {
            case GENERAL -> "9";
            case SPORTS -> "21";
            case GEOGRAPHY -> "22";
            case HISTORY -> "23";
            case CELEBRITIES -> "26";
        };
    }

    private String getApiDifficulty() {
        return switch (difficulty) {
            case Easy -> "easy";
            case Normal -> "medium";
            case Hard -> "hard";
        };
    }


}
