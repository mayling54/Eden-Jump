package gamelogic;

import java.awt.Color;
import java.awt.Graphics;

import gamelogic.player.Player;
import gamelogic.tiledMap.Map;

public class LevelCompleteBar {

	private int x;
	private int y;
	private int width;
	private int height;

	private Player player;

	private float levelComplete; //in percent

	public LevelCompleteBar(int x, int y, int width, int height, Player player) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.player = player;
	}

	public void update(float tslf) {
		Map map = player.getLevel().getMap();
		if(map != null) {
			this.levelComplete = (player.getX() / map.getFullWidth());
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		
		g.fillOval((int)(x + levelComplete * width), y, height, height);
	}

}
