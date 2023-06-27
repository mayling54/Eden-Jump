package mapeditor;

import java.awt.image.BufferedImage;

class PaletteItem {

	private String name;
	private int value;
	private BufferedImage image;
	
	public PaletteItem(String name, int value, BufferedImage image) {
		this.name = name;
		this.value = value;
		this.image = image;
	}
	
	
	//-----------------------------------Getters
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
