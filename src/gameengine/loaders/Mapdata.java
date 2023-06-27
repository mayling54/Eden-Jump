package gameengine.loaders;

public class Mapdata {

	private int width;
	private int height;
	private int tileSize;
	private int[][]values;
	
	public Mapdata(int width, int height, int tileSize, int[][]values) {
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		this.values = values;
	}
	
	//------------------------------------------Getters
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getTileSize() {
		return tileSize;
	}
	
	public int[][] getValues() {
		return values;
	}
}
