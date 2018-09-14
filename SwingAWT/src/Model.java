import java.beans.PropertyChangeListener;

import javax.swing.event.SwingPropertyChangeSupport;

import visuals.Square;
import visuals.Vehicle;

public class Model{
	private final int VEH_X = 300, VEH_Y = 300, VEH_HEIGHT = 75, VEH_WIDTH = 100,
			SQR_X = 20, SQR_Y = 20, SQR_SIDE = 700;
	Vehicle vehicle;
	Square square;
	SwingPropertyChangeSupport propChangeRegisterer;
	
	public Model(){
		propChangeRegisterer = new SwingPropertyChangeSupport(this);
		vehicle = new Vehicle(VEH_X,VEH_Y,VEH_WIDTH,VEH_HEIGHT);
		square = new Square(SQR_X, SQR_Y, SQR_SIDE);	
	}
	
	public void addListener(PropertyChangeListener prop) {
        propChangeRegisterer.addPropertyChangeListener(prop);
    }
	
	public Vehicle getVehicle(){
		return vehicle;
	}
	
	public Square getSquare(){
		return square;
	}
	
	// these should really be in their own classes, but I dont want to bother with 
	// listener support right now
	public void moveVehicle(int x, int y){
		int leftBound = SQR_X + 10 - 1;
		int upBound = SQR_Y + 10 - 1;
		int rightBound = SQR_X + SQR_SIDE - 10 + 1;
		int downBound = SQR_Y + SQR_SIDE - 10 + 1;
		
		if((x < 0 && vehicle.getX() > leftBound) || (y < 0 && vehicle.getY() > upBound) ||
				(x > 0 && vehicle.getWidth() + vehicle.getX() < rightBound) ||
				(y > 0 && vehicle.getHeight() + vehicle.getY() < downBound)){
			vehicle.setX(vehicle.getX() + x);
			vehicle.setY(vehicle.getY() + y);
			vehicle.getBody().setLocation((int)vehicle.getBody().getX()+x, (int)vehicle.getBody().getY()+y);
			vehicle.getBackWheel().setFrame(vehicle.getBackWheel().getX()+x, vehicle.getBackWheel().getY()+y, vehicle.getBackWheel().getWidth(), vehicle.getBackWheel().getHeight());
			vehicle.getFrontWheel().setFrame(vehicle.getFrontWheel().getX()+x, vehicle.getFrontWheel().getY()+y, vehicle.getFrontWheel().getWidth(), vehicle.getFrontWheel().getHeight());
			propChangeRegisterer.firePropertyChange(null, null, vehicle);
		}
	}
	
	public void becomeCar(){
		if(vehicle.isBus()){
			vehicle.setIsBus(false);
			vehicle.setY(vehicle.getY() + vehicle.getBodyHeight() / 2);
			vehicle.setBodyHeight(vehicle.getBodyHeight() / 2);
			vehicle.setHeight(vehicle.getHeight() - vehicle.getBodyHeight());
			propChangeRegisterer.firePropertyChange(null, null, vehicle);
		}
	}
	
	public void becomeBus(){
		int upBound = SQR_Y - 1;
		
		if(!vehicle.isBus() && vehicle.getY() - vehicle.getBodyHeight() > upBound){
			vehicle.setIsBus(true);
			vehicle.setY((int)(vehicle.getY() - vehicle.getBodyHeight()));
			vehicle.setBodyHeight(vehicle.getBodyHeight() * 2);
			vehicle.setHeight(vehicle.getHeight() + vehicle.getBodyHeight() / 2);
			propChangeRegisterer.firePropertyChange(null, null, vehicle);
		}
	}
	
	public void doubleSize(){
		int upBound = SQR_Y - 1;
		
		if(vehicle.getY() - vehicle.getHeight() > upBound){
			
		}
	}
}
