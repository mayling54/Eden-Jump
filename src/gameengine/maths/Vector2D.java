package gameengine.maths;

public class Vector2D {

	public float x;
	public float y;
	
	public Vector2D() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[x:" + String.format("%1.2f", x) + " y:" + String.format("%1.2f", y) + "]"; 
	}
}
