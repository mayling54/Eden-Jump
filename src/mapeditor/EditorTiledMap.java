package mapeditor;

import java.awt.Color;
import java.awt.Graphics;

import gameengine.input.MouseInputManager;

class EditorTiledMap {
	public static final Color MOUSE_OVER = new Color(0, 255, 0, 100);

	private EditorTile[][] tiles;
	private int width; //width of the map in number of tiles
	private int height; //height of the map in number of tiles
	private int tileSize; //the size of one tile;

	private EditorTile mouseOver;
	private int mouseTileX;
	private int mouseTileY;

	private int playerX;
	private int playerY;
	
	public EditorTiledMap(int width, int height, int tileSize, EditorTile[][]tiles, int playerX, int playerY) {
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		this.tiles = tiles;
		this.playerX = playerX;
		this.playerY = playerY;
	}

	public void update(float tslf) {
		float mouseX = MouseInputManager.getMouseX();
		float mouseY = MouseInputManager.getMouseY();

		//Highlight the tile the mouse is on
		mouseOver = null;
		int tileX = (int) ((mouseX + MapEditor.camera.getX()) / tileSize);
		int tileY = (int) ((mouseY + MapEditor.camera.getY()) / tileSize);
		if(tileX >= 0 && tileX < width && tileY >= 0 && tileY < height) {
			mouseOver = tiles[tileX][tileY];
			mouseTileX = tileX;
			mouseTileY = tileY;
		}
	}

	public void draw(Graphics g) {
		//Fill tiles
		g.setColor(Color.LIGHT_GRAY);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				EditorTile tile = tiles[x][y];

				if(!MapEditor.camera.isVisibleOnCamera(tile.getX(), tile.getY(), tile.getSize(), tile.getSize())) continue;
				if(tile.getImage() != null) g.drawImage(tile.getImage(), tile.getX(), tile.getY(), tileSize, tileSize, null);
			}
		}
		
		//Player position
		g.setColor(new Color(0, 255, 255, 100));
		g.fillRect(playerX*tileSize + 5, playerY*tileSize + 5, tileSize - 10, tileSize - 10);

		//Highlight the tile the mouse is on
		if(mouseOver != null) {
			g.setColor(MOUSE_OVER);
			g.fillRect(mouseOver.getX(), mouseOver.getY(), tileSize, tileSize);
		}

		//Draw outlines
		drawOutlines(g);
	}

	public void drawOutlines(Graphics g) {
		g.setColor(Color.BLACK);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				EditorTile tile = tiles[x][y];

				if(!MapEditor.camera.isVisibleOnCamera(tile.getX(), tile.getY(), tile.getSize(), tile.getSize())) continue;
				tile.drawOutline(g);
			}
		}
	}
	
	//------------------------------------------Getters
	public int getMouseTileX() {
		return mouseTileX;
	}
	
	public int getMouseTileY() {
		return mouseTileY;
	}
	
	public EditorTile getMouseOver() {
		return mouseOver;
	}

	public void setPlayerPositon(int x, int y) {
		this.playerX = x;
		this.playerY = y;
	}
	
	public int getPlayerX() {
		return playerX;
	}
	
	public int getPlayerY() {
		return playerY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getTileSize() {
		return tileSize;
	}

	public EditorTile[][] getTiles() {
		return tiles;
	}
}
