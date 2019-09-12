/**
 * `View` acts as the Subject in the example. 
 */
package observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends AbstractSubject<String> {
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JTextField input;
    private JButton submit;


    public View () {
        frame = new JFrame("Observer CHANGE");
        panel = new JPanel();
        
        textArea = new JTextArea(20,20);
        input = new JTextField(20);
        submit = new JButton("Submit");

        
        this.register(new ConsoleListener());
        this.register(new TextAreaListener(textArea));

        AbstractSubject<String> that = this;

        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                that.notify(input.getText());
            }
        });

        panel.add(textArea);
        panel.add(input);
        panel.add(submit);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) {
        View view = new View();
    }
}