import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    // testing Food, ShoppingBag, FoodMenu, TakeOutSimulator classes
    {
      Food testFood1 = new Food("Dry cat fud", "Crunchy bits for the strays you tolerate", 1);
      Food testFood2 = new Food("Wet cat fud", "Juicy bits for the strays you like", 2);

      testFood1.setName("Dry Cat Food");
      testFood2.setName("Wet Cat Food");
      testFood1.setPrice(2);
      testFood2.setPrice(3);

      ShoppingBag testBag1 = new ShoppingBag();
      ShoppingBag testBag2 = new ShoppingBag();
      ShoppingBag testBag3 = new ShoppingBag(new Food("Tacos", "Tacos", 5));
      testBag1.addItem(testFood1);
      testBag2.addItem(testFood1);
      testBag2.addItem(testFood2);
      testBag2.addItem(testFood2);

      FoodMenu testMenu1 = new FoodMenu();
      testMenu1.addFoodItem(testFood1);
      testMenu1.addFoodItem(testFood2);
      System.out.println(testMenu1.length());
      System.out.println(testMenu1.getFood(1));
      System.out.println(testMenu1.getFood(1) instanceof Food);

      Customer pau = new Customer("Pau", 1200);
      System.out.println("Customer: " + pau.getName());
      
      
      // create anonymous class implementation of UserInputRetriever
      UserInputRetriever<Food> anonymousUserInputRetriever = new UserInputRetriever<Food>() {
        @Override
        public Food produceOutput(int selection) {
          if (selection > 0 && selection <= testMenu1.length()) {
            return testMenu1.getFood(selection);
          } else {
            throw new IllegalArgumentException("Invalid Choice. Please choose an integer (1-" + testMenu1.length() + ").");
          }
        }
      };
      TakeOutSimulator testSimulator = new TakeOutSimulator(pau, testMenu1, new Scanner(System.in));
      //testSimulator.getResponse("Select an item from the menu.", anonymousUserInputRetriever);

      
    }
  }    
}
