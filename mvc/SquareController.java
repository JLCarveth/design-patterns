package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class SquareController implements ActionListener, FocusListener {

    private SquareModel model;

    private SquareView view;
   	private AlternateSquareView altView;

    public SquareController(int value) {

		model = new SquareModel(value);

		view = new SquareView(model,this);
		altView = new AlternateSquareView(model,this);
		altView.setLocation(view.getX()+view.getWidth()+10, view.getY());
		update();
    }

    public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
		    model.square();
		    update();
		}
    }

    public void focusGained(FocusEvent e) {}

	public void focusLost(FocusEvent e){
		if(e.getSource() instanceof JTextField) {
		    model.setValue(view.getTheCurrentValue());
		}
	}

    private void update(){
		view.update();
		altView.update();

    }

}
