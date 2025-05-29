import java.util.Scanner;

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
}