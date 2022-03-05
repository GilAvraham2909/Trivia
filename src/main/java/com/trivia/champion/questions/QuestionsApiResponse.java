package com.trivia.champion.questions;

import java.util.List;

public class QuestionsApiResponse {
    private String response_code;
    private List<ApiQuestion> results;

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public List<ApiQuestion> getResults() {
        return results;
    }

    public void setResults(List<ApiQuestion> results) {
        this.results = results;
    }
}
