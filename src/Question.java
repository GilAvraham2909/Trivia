import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Question {
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;
    private Map<Integer, String> map = new HashMap();

    public Question(String question, String correctAnswer, List<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
        createMap();
    }

    private void createMap() {
        int min = 1;
        Random random = new Random();
        int correctIndex = min + random.nextInt(4);
        map.put(correctIndex, correctAnswer);
        for (int i = 1; i < correctIndex; i++) {
            map.put(i, incorrectAnswers.get(i - 1));
        }
        for (int i = correctIndex + 1; i < 5; i++) {
            map.put(i, incorrectAnswers.get(i - 2));
        }
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public String toString() {
        String head = "\n" + question;
        String underline = "\n-------------------------";
        String answer1 = "\n1. " + map.get(1);
        String answer2 = "\n2. " + map.get(2);
        String answer3 = "\n3. " + map.get(3);
        String answer4 = "\n4. " + map.get(4);
        return head + underline + answer1 + answer2 + answer3 + answer4;
    }

}
