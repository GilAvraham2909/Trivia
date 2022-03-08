package com.trivia.champion.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivia.champion.categories.ApiCategories;
import com.trivia.champion.enums.Difficulty;
import com.trivia.champion.questions.ApiQuestion;
import com.trivia.champion.questions.Question;
import com.trivia.champion.questions.QuestionList;
import com.trivia.champion.questions.QuestionsApiResponse;
import com.trivia.champion.ui.output.player.IPlayerUi;
import com.trivia.champion.ui.output.player.PlayerConsole;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.trivia.champion.utils.Constants.*;

public class ApiQuestionsParser implements IQuestionsParser {
    private HttpClient client;
    private String category;
    private Difficulty difficulty;
    private IPlayerUi display = PlayerConsole.getInstance();

    public ApiQuestionsParser(String category, Difficulty difficulty) {
        this.client = HttpClient.newHttpClient();
        this.category = category;
        this.difficulty = difficulty;
    }

    @Override
    public QuestionList parse() throws Exception {
        QuestionList questionList = new QuestionList();
        QuestionsApiResponse questionsApiResponse = getQuestions();
        if (questionsApiResponse.getResults().size() == 0) {
            display.showApiProblem();
            return questionList;
        }
        for (int i = 0; i <NUM_OF_QUESTIONS; i++) {
            ApiQuestion apiQuestion = questionsApiResponse.getResults().get(i);
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

    private QuestionsApiResponse getQuestions() throws Exception {
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

    private String createApiRequest() throws Exception {
        String amount = "amount=" + NUM_OF_QUESTIONS + "&";
        String category = "category=" + getApiCategoryId() + "&";
        String difficulty = "difficulty=" + getApiDifficulty() + "&";
        return QUESTIONS_API_PREFIX + amount + category + difficulty + QUESTIONS_API_SUFFIX;
    }

    private int getApiCategoryId() throws Exception {
        return new ApiCategories().getCategoryId(category);
    }

    private String getApiDifficulty() {
        return switch (difficulty) {
            case Easy -> "easy";
            case Normal -> "medium";
            case Hard -> "hard";
        };
    }


}
