import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    // INSTANCE FIELDS
    private List<Food> menu;

    // CONSTRUCTOR
    public FoodMenu() {
        this.menu = new ArrayList<Food>;
        menu.add(new Food("Tacos", "Yummy steak tacos", 15));
        menu.add(new Food("Dumplings", "Delicious steamed dumplings", 10));
        menu.add(new Food("Ramen", "Hot pork ramen", 12));
    }
}