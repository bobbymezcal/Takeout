public interface PricedItem<T> {
    T getPrice();
    void setPrice(T price);
}