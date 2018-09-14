package visuals;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class Vehicle {
	boolean isBus = false;
	int x;
	int y;
	int height;
	int width;
	int bodyHeight;
	Rectangle body;
	Ellipse2D.Double backWheel;
	Ellipse2D.Double frontWheel;
	
	public Vehicle(int inX, int inY, int w, int h){
		x = inX;
		y = inY;
		width = w;
		height = h;
		bodyHeight = height * 3 / 4;
		
		Rectangle body = new Rectangle(x, y, width, bodyHeight);
		Ellipse2D.Double backWheel = new Ellipse2D.Double(x, y+((Rectangle) body).getHeight(), ((Rectangle)body).getWidth()/4, ((Rectangle)body).getWidth()/4);
		Ellipse2D.Double frontWheel = new Ellipse2D.Double(x+((Rectangle) body).getWidth() - ((Rectangle)body).getWidth()/4, y+((Rectangle) body).getHeight(), ((Rectangle)body).getWidth()/4, ((Rectangle)body).getWidth()/4);
		
		this.setBody(body);
		this.setBackWheel(backWheel);
		this.setFrontWheel(frontWheel);
	}
	
	public void setIsBus(boolean b){
		isBus = b;
	}
	
	public boolean isBus(){
		return isBus;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int inX){
		x = inX;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int inY){
		y = inY;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	public Rectangle getBody(){
		return body;
	}
	
	public Ellipse2D.Double getBackWheel(){
		return backWheel;
	}
	
	public Ellipse2D.Double getFrontWheel(){
		return frontWheel;
	}
	
	public void setBody(Rectangle b){
		body = b;
	}
	
	public void setBackWheel(Ellipse2D.Double b){
		backWheel = b;
	}
	
	public void setFrontWheel(Ellipse2D.Double f){
		frontWheel = f;
	}
	
	public void setBodyHeight(int i){
		bodyHeight = i;
	}
	
	public int getBodyHeight(){
		return bodyHeight;
	}
	
	
}
