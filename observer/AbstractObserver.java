package observer;

/**
 * Abstract implementation of an Observer object.
 * @param <E>
 */
public abstract class AbstractObserver<E> {
    /**
     * Called when a state change has been made.
     * @param data the data passed from the Subject
     */
    abstract void notify(E data);
}