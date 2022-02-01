import java.util.List;

public class QuestionsManager {
    private Category category;
    private Difficulty difficulty;
    private List<Question> questionsList;
    private IParser parser;

    public QuestionsManager(Category category, Difficulty difficulty) {
        this.category = category;
        this.difficulty = difficulty;
    }

    public List<Question> initializeQuestions() {
        return parser.parse();
    }

    public void nextQuestion() {

    }

}
