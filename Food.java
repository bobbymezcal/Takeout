public class Food implements PricedItem<Integer> {
    // INSTANCE FIELDS
    private String name, description;
    private int price;

    // CONSTRUCTOR
    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // getters
    @Override
    public Integer getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Enjoy " + this.name + ": " + this.description + "    Cost: $" + this.price;
    }
    public String getName() {
        return this.name;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }   
}