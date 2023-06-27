package gamelogic.tiles;

import java.awt.image.BufferedImage;

import gameengine.hitbox.RectHitbox;
import gamelogic.level.Level;

public class Flower extends Tile{
	private int type;
	public Flower(float x, float y, int size, BufferedImage image, Level level, int type) {
		super(x, y, size, image, false, level);
		this.type = type;
		this.hitbox = new RectHitbox(x*size , y*size, 0, 10, size, size);
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

}
