import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem<Integer>> {
    // INSTANCE FIELDS
    private Map<T, Integer> shoppingBag;

    // CONSTRUCTOR
    public ShoppingBag() {
        this.shoppingBag = new HashMap();
    }

}