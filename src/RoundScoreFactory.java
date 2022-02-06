public class RoundScoreFactory {

    public RoundScore makeRoundScore(Difficulty difficulty) {
        switch (difficulty) {
            case Easy -> { return new EasyRoundScore(); }
            case Normal -> { return new NormalRoundScore(); }
            case Hard -> { return new HardRoundScore(); }
            default -> { return null; }
        }
    }
}
