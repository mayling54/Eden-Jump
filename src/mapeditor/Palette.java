package mapeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import gameengine.input.MouseInputManager;
import gameengine.maths.Vector2D;

class Palette {

	private Vector2D position;
	private int width;
	private int height;
	private PaletteItem[] paletteItems;
	private int tileSize = 50;
	private int tilesPerRow = 5;

	private int selectedIndex = -1;

	public Palette(float x, float y, PaletteItem[] paletteItems) {
		this.position = new Vector2D(x, y);
		this.paletteItems = paletteItems;
		this.width = tilesPerRow * tileSize;
		if(paletteItems.length < tilesPerRow) {
			this.width = paletteItems.length * tileSize;
		}
		this.height = (int)(paletteItems.length / tilesPerRow) * tileSize;
		if(paletteItems.length % tilesPerRow != 0) {
			this.height = (int)(paletteItems.length / tilesPerRow + 1) * tileSize;
		}
	}

	public void update(float tslf) {
		float mouseX = MouseInputManager.getMouseX();
		float mouseY = MouseInputManager.getMouseY();

		//Highlight the tile the mouse is on
		if(position.x < mouseX && position.y < mouseY) {

			int tileX = (int) ((mouseX - position.x) / tileSize);
			int tileY = (int) ((mouseY - position.y) / tileSize);
			int index = tileY * tilesPerRow + tileX;
			if(0 <= index && index < paletteItems.length) {
				if(MouseInputManager.isButtonDown(MouseEvent.BUTTON1)) {
					selectedIndex = index;
				}
			}
		}
	}

	public void draw(Graphics g) {
		g.translate((int)position.x, (int)position.y);
		//fill
		for (int i = 0; i < paletteItems.length; i++) {
			BufferedImage image = paletteItems[i].getImage();
			if(image != null) g.drawImage(image, i % tilesPerRow * tileSize, (int)(i/tilesPerRow) * tileSize, tileSize, tileSize, null);
		}

		//outlines
		g.setColor(Color.BLACK);
		for (int i = 0; i < paletteItems.length; i++) {
			g.drawRect(i % tilesPerRow * tileSize, (int)(i/tilesPerRow) * tileSize, tileSize, tileSize);
		}
		g.setColor(Color.GREEN);
		g.drawRect(0, 0, width, height);
		
		//selected
		if(0 <= selectedIndex) {
			g.setColor(Color.RED);
			g.drawRect(selectedIndex % tilesPerRow * tileSize, (int)(selectedIndex/tilesPerRow) * tileSize, tileSize, tileSize);
		}

		g.translate((int)-position.x, (int)-position.y);
	}

	//--------------------------------------Getters
	public PaletteItem[] getPaletteItems() {
		return paletteItems;
	}
	
	public PaletteItem getSelectedPaletteItem() {
		return paletteItems[selectedIndex];
	}
	
	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}