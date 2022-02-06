import static utils.Constants.HARD_QUESTION_SCORE;

public class HardRoundScore extends RoundScore {
    @Override
    public void addPoints() {
        int currentScore = getScore();
        setScore(currentScore + HARD_QUESTION_SCORE);
    }

}
