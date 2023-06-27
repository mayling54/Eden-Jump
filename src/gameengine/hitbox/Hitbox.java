package gameengine.hitbox;

import java.awt.Graphics;

/**
 * 
 * @author Paul
 *
 */
public abstract class Hitbox {
	
	public static final boolean SHOW_HITBOXES = false; //used for debugging

	public abstract void update();
	
	public abstract void draw(Graphics graphics);
}
