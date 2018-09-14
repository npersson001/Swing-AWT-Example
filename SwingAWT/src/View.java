import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class View extends Component implements PropertyChangeListener{
	private JFrame frame;
	private Model model;
	private BasicStroke stroke;
	
	public View(Model m){
		model = m;
		m.addListener(this);
		
		frame = new JFrame("Swing/AWT Experiment");
		frame.add(this);
		frame.setSize(800,800);        
        frame.setVisible(true);
        
        stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
                5f);
	}
	
	public void paint(Graphics g){
		super.paint(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(stroke);
	    g.setColor(Color.BLACK);
	    draw(g2);
	}
	
	public void draw(Graphics2D g){
		setBackground(Color.WHITE);  
		g.setColor(Color.YELLOW);
		g.drawRect(model.getSquare().getX(), model.getSquare().getY(), model.getSquare().getSide(), 
				model.getSquare().getSide());
		g.setColor(Color.BLACK);
		g.fillOval((int)model.getVehicle().getBackWheel().getX(), (int)model.getVehicle().getBackWheel().getY(),
				(int)model.getVehicle().getBackWheel().getWidth(), (int)model.getVehicle().getBackWheel().getHeight());
		g.fillOval((int)model.getVehicle().getFrontWheel().getX(), (int)model.getVehicle().getFrontWheel().getY(),
				(int)model.getVehicle().getFrontWheel().getWidth(), (int)model.getVehicle().getFrontWheel().getHeight());
		g.setColor(Color.RED);
		if(model.getVehicle().isBus()){
			g.fillRect((int)model.getVehicle().getX(), (int)model.getVehicle().getY(),
					(int)model.getVehicle().getWidth(), (int)model.getVehicle().getHeight() / 2 + (model.getVehicle().getHeight() / 2) * 3 / 4);
		}
		else{
			g.fillRect((int)model.getVehicle().getX(), (int)model.getVehicle().getY(),
					(int)model.getVehicle().getWidth(), (int)model.getVehicle().getHeight() * 3 / 4);
		}
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		repaint();
	}
	
}
