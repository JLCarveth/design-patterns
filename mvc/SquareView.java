package mvc;

import java.awt.GridLayout;
import javax.swing.*;

/**
 * An implementation of the view component.
 */
public class SquareView extends JFrame {
    // Since the class extends the serializable JFrame
    static final long serialVersionUID = 1L;
    
    private JTextField input;
    private SquareModel model;

    /**
     * Initializes a new SquareView object
     * @param model the model component which holds the data
     * @param controller the controller component
     */
    public SquareView(SquareModel model, SquareController controller) {
        // Calling the JFrame constructor
        super("Square GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));

    	this.model = model;

    	JButton button;
        button = new JButton("Square");
        // SquareController extends ActionListener, and any other required
        // Listener interfaces
        button.addActionListener(controller);
        add(button);

    	input = new JTextField();
    	input.addActionListener(controller);
        input.addFocusListener(controller);
        add(input);

        pack();
        setVisible(true);
    }

    /**
     * Called by the controller when the view should be updated
     */
    public void update() {
	   input.setText(Long.toString(model.getValue()));
    }

    /**
     * 
     * @return
     */
    public Long getTheCurrentValue(){
        return Long.parseLong(input.getText());
    }
    
   
}
