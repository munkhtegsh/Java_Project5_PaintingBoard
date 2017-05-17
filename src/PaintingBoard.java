
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

	//creating PaintingBoard class from JPanel
public class PaintingBoard extends JPanel { 
	
	//creating instance variables
	private final static int DIAMETER = 10;	
	private ArrayList <Point> drawingList;
	private Point startPoint, endPoint;
	private boolean selectingStartPoint;
	private String changeColor;
	private boolean clearField;
	
	//creating a constructor
	public PaintingBoard () {
		
		startPoint = null;
		endPoint = null;
		selectingStartPoint = true;	
		
		setBackground(Color.WHITE);
		drawingList = new ArrayList<Point>();
		this.addMouseListener(new MouseListener());
		this.addMouseMotionListener(new MouseListener());
	}
	
	//Overriding paintComponent method
	@Override	
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		
		//takes the starting and ending points, but also it fills the Arraylist
		if(startPoint != null && endPoint != null){
		for(Point point: drawingList){
			int startX = (int) point.getX();
			int startY = (int) point.getY();
			int endX = (int) point.getX();
			int endY = (int) point.getY();
			pen.fillOval(startX, startY, DIAMETER, DIAMETER);
			pen.fillOval(endX, endY, DIAMETER, DIAMETER);
			
			//changing colors through a setColor method
			if(changeColor == "Black"){
				pen.setColor(Color.BLACK);
			} else if(changeColor == "Cyan"){
				pen.setColor(Color.CYAN);
			} else if(changeColor == "Red"){
				pen.setColor(Color.RED);
			} else if(changeColor == "White"){
				pen.setColor(Color.WHITE);
			} 
			
			if(clearField == true){
				//... 
			}
		}
		}
	}
	
	//creating action listener
	private class MouseListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent event){
			Point point = event.getPoint();
			if(selectingStartPoint){
				startPoint = point;
				drawingList.add(point);
			} else {
				endPoint = point;
			}
			selectingStartPoint = !selectingStartPoint;
			repaint();
		}
		
		@Override
		public void mouseMoved(MouseEvent event){
			Point point = event.getPoint();
			if(selectingStartPoint){
				drawingList.add(point);
				repaint();
			}
		}

	}
	
	//changeColor method
	public void setColor(String changeColor) {
		this.changeColor = changeColor;	
	}
	
	//clear method
	public void setClearField(boolean clearField){
		this.clearField = clearField;
	}

	public static void main(String args[]) {
	
			   EventQueue.invokeLater(new Runnable() {
				public void run() {
					JFrame frame = new JFrame("Painting Board");
					frame.setSize(400, 400);

					PaintingBoard panel = new PaintingBoard();
					frame.getContentPane().add(panel, BorderLayout.CENTER);
					
					BoardClass board = new BoardClass(panel);
					frame.getContentPane().add(board, BorderLayout.SOUTH);
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			   });
	}
}