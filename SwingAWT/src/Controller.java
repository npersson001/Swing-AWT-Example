import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements KeyListener, MouseListener{
	private Model model;
	private View view;
	
	public Controller(Model m, View v){
		model = m;
		view = v;
		view.setFocusable(true);
		view.requestFocus();
		view.addKeyListener(this);
		view.addMouseListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		switch(arg0.getKeyChar()){
		case 'w':
			model.moveVehicle(0,-10);
			break;
		case 's':
			model.moveVehicle(0,10);
			break;
		case 'a':
			model.moveVehicle(-10,0);
			break;
		case 'd':
			model.moveVehicle(10,0);
			break;
		case 'r':
			model.becomeCar();
			break;
		case 'm':
			model.doubleSize();
			break;
		default:
			break;	
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		model.becomeBus();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
