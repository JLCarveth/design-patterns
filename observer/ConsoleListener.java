package observer;

/**
 * An implementation of the AbstractObserver which outputs given data to the
 * console.
 */
public class ConsoleListener extends AbstractObserver<String> {
    @Override
    public void notify(String data) {
        System.out.println(data);
    }
}