package observer;

import java.util.ArrayList;
/**
 * An abstract implementation of a Subject object. All concrete implementations
 * of a Subject object should inherit this class.
 */
public abstract class AbstractSubject<E> {
    private ArrayList<AbstractObserver<E>> observers = new ArrayList<>();

    /**
     * Registers a new observer.
     * @param observer the observer to be registered to this Subject
     * @return true as per `Collection.add`
     */
    public boolean register(AbstractObserver<E> observer) {
        return observers.add(observer);
    }

    /**
     * Removes the specified observer from the Subject's list of registered
     * observers.
     * @param observer the observer to be removed 
     * @return true if the observer was contained within the list
     */
    public boolean remove(AbstractObserver<E> observer) {
        return observers.remove(observer);
    }

    public void notify(E data) {
        for (AbstractObserver<E> o : observers) {
            o.notify(data);
        }
    }
}