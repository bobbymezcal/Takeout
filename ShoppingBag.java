import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem<Integer>> {
    // INSTANCE FIELDS
    private Map<T, Integer> shoppingBag;

    // CONSTRUCTOR
    public ShoppingBag() {
        this.shoppingBag = new HashMap();
    }

    public void addItem(T item) {
        if (shoppingBag.get(item) == null) {
            shoppingBag.put(item, 1);
        } else {
            shoppingBag.put(item, (shoppingBag.get(item) + 1));
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (T key : shoppingBag.keySet()) {
            totalPrice += shoppingBag.get(key) * key.getPrice();
        }
        return totalPrice;
    }

}