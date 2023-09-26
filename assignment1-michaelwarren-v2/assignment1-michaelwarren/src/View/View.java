package View;
import java.util.Scanner;

/*
 * The View class is a very simple class for displaying messages (displayMessage)
 * and for gathering input from the user (inputMessage)
 * The displayMessage also checks whether the user attempts to quit the game (if they type "quit")
 * */

public class View {

    public Scanner scanner;
    public View() {
        this.scanner = new Scanner(System.in);
    } // Scanner initiated at construction

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String inputMessage() {
        // Check if quitting
        String inMessage = scanner.nextLine();
        if (inMessage.equals("quit")) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
        // Returns input text in lower case form
        return inMessage;
    }

    // Convert to lower case before checking against noun and verb combinations
    public String inputLowerCaseMessage() {
        // Check if quitting
        String inMessage = scanner.nextLine();
        if (inMessage.equals("quit")) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
        // Returns input text in lower case form
        return inMessage.toLowerCase();
    }

    // Integer input - note I used ChatGPT to help me structure this function (hadn't used try catch in Java yet)
    // What I typed: example try-catch for user input as an integer in Java

    public int inputInteger() {
        int number = 0; // Initialize to a default value

        boolean validInput = false;

        // Checks if integer entered - repeats invalid input until entered correctly
        while (!validInput) {
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
                validInput = true; // If parsing succeeds, set the flag to true to exit the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return number;
    }

}