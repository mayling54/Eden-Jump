package gamelogic.tiles;

import gameengine.hitbox.RectHitbox;
import gameengine.loaders.Tileset;
import gamelogic.GameResources;
import gamelogic.level.Level;

public class Spikes extends Tile{

	public static final int HORIZONTAL_DOWNWARDS = 0;
	public static final int HORIZONTAL_UPWARDS = 1;
	public static final int VERTICAL_LEFTWARDS = 2;
	public static final int VERTICAL_RIGHTWARDS = 3;
	
	private int offsetX = 25;
	private int offsetY = 70;
	
	public Spikes(float x, float y, int size, int orientation, Level level) {
		super(x, y, size, null, true, level);
		
		Tileset tileset = GameResources.tileset;
		
		switch (orientation) {
		case HORIZONTAL_UPWARDS:
			hitbox = new RectHitbox(x*size , y*size, offsetX, offsetY, size - offsetX, size);
			image = tileset.getImage("Spikes_upwards");
			break;
		case HORIZONTAL_DOWNWARDS:
			hitbox = new RectHitbox(x*size , y*size, offsetX, 0, size - offsetX, size - offsetY);
			image = tileset.getImage("Spikes_downwards");;
			break;
		case VERTICAL_LEFTWARDS:
			hitbox = new RectHitbox(x*size , y*size, offsetY, offsetX, size, size - offsetX);
			image = tileset.getImage("Spikes_leftwards");;
			break;
		case VERTICAL_RIGHTWARDS:
			hitbox = new RectHitbox(x*size , y*size, 0, offsetX, size - offsetY, size - offsetX);
			image = tileset.getImage("Spikes_rightwards");;
			break;

		default:
			break;
		}
	}
}
