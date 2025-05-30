import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // testing Food, ShoppingBag, FoodMenu, TakeOutSimulator classes
    Food testFood1 = new Food("Dry cat fud", "Crunchy bits for the strays you tolerate", 1);
    Food testFood2 = new Food("Wet cat fud", "Juicy bits for the strays you like", 2);

    testFood1.setName("Dry Cat Food");
    testFood2.setName("Wet Cat Food");
    testFood1.setPrice(2);
    testFood2.setPrice(3);

    ShoppingBag<Food> testBag1 = new ShoppingBag<>();
    ShoppingBag<Food> testBag2 = new ShoppingBag<>();
    ShoppingBag<Food> testBag3 = new ShoppingBag<>();
    testBag3.addItem(new Food("Tacos", "Tacos", 5));
    testBag1.addItem(testFood1);
    testBag2.addItem(testFood1);
    testBag2.addItem(testFood2);
    testBag2.addItem(testFood2);

    FoodMenu testMenu1 = new FoodMenu();
    testMenu1.addFoodItem(testFood1);
    testMenu1.addFoodItem(testFood2);

    Customer pau = new Customer("Pau", 1200);
    System.out.println("Customer: " + pau.getName());      
      
    TakeOutSimulator testSimulator = new TakeOutSimulator(pau, testMenu1, new Scanner(System.in));
    testSimulator.startTakeOutSimulator();
    }    
}
