package gamelogic.tiles;

import java.awt.image.BufferedImage;

import gameengine.hitbox.RectHitbox;
import gamelogic.level.Level;

public class SolidTile extends Tile{
	
	public SolidTile(float x, float y, int size, BufferedImage image, Level level) {
		super(x, y, size, image, true, level);
		this.hitbox = new RectHitbox(x *size, y*size, 0, 10, size, size);
	}
	public String toString() {
		return "I'm a solidTile at "+this.position.x+" "+this.position.y;
	}
}
