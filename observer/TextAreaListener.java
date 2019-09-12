package observer;

import javax.swing.JTextArea;

/**
 * An implementation of the AbstractObserver, which stores incoming data
 * in a jawax.swing.JTextArea object.
 */
public class TextAreaListener extends AbstractObserver<String> {

    private JTextArea textArea;

    /**
     * Initializes a new Listener 
     * @param textArea the JTextArea object that will store the incoming data. 
     */
    public TextAreaListener(JTextArea textArea) {
        this.textArea = textArea;
        System.out.println("initialized");
    }

    /**
     * Adds the incoming data to the assigned JTextArea object
     * @param data the String data passed from the Subject
     */
    @Override
    public void notify(String data) {
        String current = textArea.getText().toString();
        current = current.concat("\n" + data);
        textArea.setText(current);
    }
}