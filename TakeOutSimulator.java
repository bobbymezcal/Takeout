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
        while (true) {
            try (Scanner input = new Scanner(System.in)) {
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

    public boolean shouldSimulate() {
        String userPrompt = "Enter 1 to CONTINUE simulation or 0 to EXIT program:";
        UserInputRetriever<Boolean> retriever = (int selection) -> {
            if (selection == 0) { 
                return false;
            } else if (selection == 1) {
                if (customer.getMoney() >= menu.getLowestCostFood().getPrice()) {
                    return true;
                } else {
                    throw new IllegalArgumentException("You don't have enough money to continue shopping");
                }
            }
            throw new IllegalArgumentException("Invalid selection");
        };
        while (true) {
            try (Scanner input = new Scanner(System.in)){
                System.out.println(userPrompt);
                return retriever.produceOutput(input.nextInt());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public Food getMenuSelection() {
        String userPrompt = "Choose a menu item by number:";
        UserInputRetriever<Food> foodRetriever = (int selection) -> {
            Food food = menu.getFood(selection);
            if (food == null) {
                throw new IllegalArgumentException("Invalid selection");   
            }
            return menu.getFood(selection);
        };
        while (true) {
            try (Scanner input = new Scanner(System.in)) {
                System.out.print(menu.toString() + "\n");
                System.out.println(userPrompt);
                if (input.hasNextInt()) {
                    Food result = foodRetriever.produceOutput(input.nextInt());
                    input.nextLine();
                    return result;
                } else {
                    System.out.println("Please enter an integer!");
                    input.nextLine();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public boolean isStillOrderingFood() {
        String userPrompt = "Enter 1 to CONTINUE shopping or 0 to CHECKOUT: ";
        UserInputRetriever<Boolean> stillOrdering = (int selection) -> {
            if (selection == 0) return false;
            if (selection == 1) return true;
            throw new IllegalArgumentException("Please enter 1 or 0");
        };
        while (true) {
            try (Scanner input = new Scanner(System.in)) {
                System.out.println(userPrompt);

                if (input.hasNextInt()) {
                    return stillOrdering.produceOutput(input.nextInt());
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    input.nextLine();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
        int remainingMoney = customer.getMoney();
        remainingMoney -= shoppingBag.getTotalPrice();
        System.out.println("\n\nProcessing payment . . .");
        System.out.println("Your remaining money: $" + remainingMoney);
        System.out.println("Thank you and enjoy your food!");
    }

    public void takeOutPrompt() {
        boolean readyToCheckout = false;
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoneyLeft = customer.getMoney();

        while (!readyToCheckout) {
            System.out.println("You have " + customerMoneyLeft + " left to spend.\n");
            System.out.println(menu.toString());
            Food selection = getMenuSelection();
            if (selection.getPrice() > customerMoneyLeft) {
                shoppingBag.addItem(getMenuSelection());
                readyToCheckout = !isStillOrderingFood();
            } else {
                System.out.println("Oops! Looks like you don't have enough for that");
                readyToCheckout = !isStillOrderingFood();
            }
        }
        checkoutCustomer(shoppingBag);
    }

}