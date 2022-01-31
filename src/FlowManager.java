public class FlowManager {
    private boolean gameFinished = false;
    private GameManager gameManager = new GameManager(false);
    private IShow display;

    public FlowManager(IShow display) {
        this.display = display;
    }

    public void gameManagement() {
        gameManager.startGame(display);
    }

}
