package factory;

/**
 * An AbstractFactory which all concrete factories should implement.
 * @param <T>
 */
public interface AbstractFactory<T> {
    /**
     * Create a new Object of type T
     * @return the created object
     */
    T create();
}