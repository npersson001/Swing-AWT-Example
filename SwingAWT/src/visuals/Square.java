package visuals;

public class Square {
	private int x, y, side;
	
	public Square(int inX, int inY, int w){
		x = inX;
		y = inY;
		side = w;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getSide(){
		return side;
	}
}
