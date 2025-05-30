import java.util.Scanner;
import java.util.InputMismatchException;

public class TakeOutSimulator {
    // INSTANCE FIELDS
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    // CONSTRUCTOR
    public TakeOutSimulator(Customer customer, FoodMenu menu, Scanner scanner) {
        this.customer = customer;
        this.menu = menu;
        this.input = scanner;
    }

    private <T> T getResponse(String userInputPrompt, UserInputRetriever<T> userInputRetriever) {
        input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(userInputPrompt);
                int userInput = input.nextInt();
                input.nextLine();
                return userInputRetriever.produceOutput(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("That was not a valid input. Try again!");
            } catch (InputMismatchException e) {
                System.out.println("Input needs to be an 'int' type.");
            }
        }
    }
}