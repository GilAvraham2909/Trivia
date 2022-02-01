// singleton class
public class FlowManager {
    public boolean gameFinished = false;
    private GameManager gameManager = GameManager.getInstance();
    private IShow display = new Console();

    private static FlowManager single_instance = null;

    private FlowManager() {}

    public static FlowManager getInstance() {
        if (single_instance == null)
            single_instance = new FlowManager();
        return single_instance;
    }

    public void start() {
        Category category = getCategory();
        if (category == null) {
            gameFinished = true;
            return;
        }
        Difficulty difficulty = getDifficulty(category);
        if (difficulty == null) {
            gameFinished = true;
            return;
        }
        gameManagement(category, difficulty);
    }

    public void gameManagement(Category category, Difficulty difficulty) {
        gameManager.startGame(category, difficulty);
    }

    private Category getCategory() {
        int category = display.mainMenu();
        return switch (category) {
            case 1 -> Category.General;
            case 2 -> Category.Science;
            case 3 -> Category.Geography;
            case 4 -> Category.Entertainment;
            case 5 -> null;
            default -> throw new IllegalStateException("Unexpected value: " + category);
        };
    }

    private Difficulty getDifficulty(Category category) {
        return switch (display.difficultyLevel(category)) {
            case 1 -> Difficulty.Easy;
            case 2 -> Difficulty.Medium;
            case 3 -> Difficulty.Hard;
            case 4 -> null;
            default -> throw new IllegalStateException("Unexpected value: " + display.difficultyLevel(category));
        };
    }
}
