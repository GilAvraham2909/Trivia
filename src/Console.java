import java.util.Scanner;

public class Console implements IShow{
    private Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    @Override
    public void show() {
        System.out.println("Welcome To TRIVIA CHAMPION");
        System.out.println("Enter choice:");
        System.out.println("continue: press 1");
        System.out.println("exit: press 2");
        while (true) {
            try{
                int userName = scanner.nextInt();  // Read user input
                System.out.println("Username is: " + userName);  // Output user input
                if (userName == 2) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Your input was not a number. Try again:");
            }

        }
    }

}
