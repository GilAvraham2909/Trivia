// singleton class
public class GameManager {
    private boolean roundFinished = false;
    private QuestionsManager questionsManager;
    private static GameManager single_instance = null;
    private IParser parser;

    private GameManager() {}

    public static GameManager getInstance() {
        if (single_instance == null)
            single_instance = new GameManager();
        return single_instance;
    }

    public void startGame(Category category, Difficulty difficulty) {
        questionsManager = new QuestionsManager(category, difficulty);
    }

    public void getScoreBoard() {
        // get the scoreboard from the ScoreboardReader
    }

}
