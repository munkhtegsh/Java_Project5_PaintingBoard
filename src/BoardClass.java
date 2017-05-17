
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Creating a class
public class BoardClass extends JPanel { 
	
	//instance variables
	private JRadioButton radioBattonBlack, radioButtonCyan, radioButtonRed, radioButtonEraser;
	private JButton clearButton;
	private PaintingBoard painting;
	
	//Constructor
	public BoardClass (PaintingBoard painting) {
		
		this.painting = painting;
		
		//Creating button labels
		radioBattonBlack = new JRadioButton("Black", true);
		this.add(radioBattonBlack, true);
		radioBattonBlack.addActionListener(new ButtonListener());
		
		radioButtonCyan = new JRadioButton("Cyan");
		this.add(radioButtonCyan);
		radioButtonCyan.addActionListener(new ButtonListener());
		
		radioButtonRed = new JRadioButton("Red");
		this.add(radioButtonRed);
		radioButtonRed.addActionListener(new ButtonListener());
		
		radioButtonEraser = new JRadioButton("Eraser");
		this.add(radioButtonEraser);
		radioButtonEraser.addActionListener(new ButtonListener());
		
		//Grouping the radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(radioBattonBlack);
		group.add(radioButtonCyan);
		group.add(radioButtonRed);
		group.add(radioButtonEraser);
		
		//Clear button
		clearButton = new JButton("Clear");
		this.add(clearButton);
		clearButton.addActionListener(new ButtonListener());
	}

	//Action listener
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(radioBattonBlack.isSelected()){
				painting.setColor("Black");
			} else if (radioButtonCyan.isSelected()){
				painting.setColor("Cyan");
			} else if (radioButtonRed.isSelected()){
				painting.setColor("Red");
			} else if (radioButtonEraser.isSelected()){
				painting.setColor("White");
			} 
			
			if(clearButton.isSelected()){
				painting.setClearField(true);
			}
			
		}
	}
}
