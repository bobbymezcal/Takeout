@FunctionalInterface
public interface UserInputRetriever<T> {
    T produceOutput(int selection) throws IllegalArgumentException;
}