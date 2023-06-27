package mapeditor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

class EditorTile {
	private int x;
	private int y;
	private int size;
	private int value;
	private BufferedImage image;
	
	public EditorTile(int x, int y, int size, int value, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.value = value;
		this.image = image;
	}
	
	public void drawOutline(Graphics g) {
		g.drawRect(x, y, size, size);
	}
	
	//-------------------------------------Getters , Setters
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
