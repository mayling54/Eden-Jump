package gamelogic.enemies;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameengine.PhysicsObject;
import gameengine.hitbox.RectHitbox;
import gamelogic.GameResources;
import gamelogic.level.Level;

public class Enemy extends PhysicsObject{

	private float walkSpeed = 80;
	private BufferedImage image;
	
	public Enemy(float x, float y, Level level) {
		super(x, y, 120, 120, level);
		movementVector.x = walkSpeed;
		this.hitbox = new RectHitbox(this, 10, 10, width - 10, height - 10);
		this.image = GameResources.enemy;
	}
	
	@Override
	public void update(float tslf) {
		super.update(tslf);
		
		if(collisionMatrix[LEF] != null) {
			movementVector.x = walkSpeed;
		} else if(collisionMatrix[RIG] != null) {
			movementVector.x = -walkSpeed;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, (int)position.x, (int)position.y, width, height, null);
		
		hitbox.draw(g);
	}
	
}