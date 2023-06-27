package gamelogic.tiledMap;

import gamelogic.tiles.Tile;

public class Map {
	
	private int width; //size in number of tiles;
	private int height; //size in number of tiles;
	private int fullWidth; //size in pixels
	private int fullHeight; //size in pixels
	private Tile[][] tiles;
	private int tileSize;
	
	public Map(int width, int height, int tileSize, Tile[][]tiles) {
		this.width = width;
		this.height = height;
		this.tiles = tiles.clone();
		this.tileSize = tileSize;
		this.fullWidth = width * tileSize;
		this.fullHeight = height * tileSize;
	}
	
	public void update(float tslf) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Tile tile = tiles[i][j];
				if(tile == null) continue;
				tile.update(tslf);
			}
		}
	}
	
	public void addTile(int col, int row, Tile t) {
		tiles[col][row]=t;
	}
	
	//-----------------------------------------------------Getters
	public int getTileSize() {
		return tileSize;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getFullWidth() {
		return fullWidth;
	}
	
	public int getFullHeight() {
		return fullHeight;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
}
