import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    // INSTANCE FIELDS
    private List<Food> menu;

    // CONSTRUCTOR
    public FoodMenu() {
        this.menu = new ArrayList<Food>();
        menu.add(new Food("Tacos", "Yummy steak tacos", 15));
        menu.add(new Food("Dumplings", "Delicious steamed dumplings", 10));
        menu.add(new Food("Ramen", "Hot pork ramen", 12));
    }

    @Override
    public String toString() {
        String menuString = "";
        for (int i = 0; i < menu.size(); i++) {
            menuString += ((i + 1) + ". " + menu.get(i).toString() + "\n");
        }
        return menuString;
    }

    public Food getFood(int index) {
        if (index < 1 || index > menu.size()) {
            return null;
        }
        return menu.get(index - 1);
    }

    public Food getLowestCostFood() {
        Food cheapestFood = menu.get(0);
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getPrice() < cheapestFood.getPrice()) {
                cheapestFood = menu.get(i);
            }
        }
        return cheapestFood;
    }
}