public class GameManager {
    private boolean roundFinished;
    private QuestionsManager questionsManager;

    public GameManager(boolean roundFinished) {
        this.roundFinished = roundFinished;
    }

    public void startGame(IShow display) {
        display.show();

    }

    public void getScoreBoard() {
        // get the scoreboard from the ScoreboardReader
    }

}
