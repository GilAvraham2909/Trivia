import java.util.List;

public class QuestionsManager {
    private String category;
    private String difficulty;
    private List<Question> questionsList;
    private IParser parser;

    public QuestionsManager(String category, String difficulty, List<Question> questionsList, IParser parser) {
        this.category = category;
        this.difficulty = difficulty;
        this.questionsList = questionsList;
        this.parser = parser;
    }

    public void nextQuestion() {

    }

}
