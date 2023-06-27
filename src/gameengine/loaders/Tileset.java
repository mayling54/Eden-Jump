package gameengine.loaders;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Tileset {
	private Map<String, BufferedImage> images;
	private Map<Integer, BufferedImage> idImages;
	private Map<Integer, String> names;
	
	public Tileset() {
		images = new HashMap<String, BufferedImage>();
		idImages = new HashMap<Integer, BufferedImage>();
		names = new HashMap<Integer, String>();
	}
	
	public void addImage(String name, Integer id, BufferedImage image) {
		images.put(name, image);
		idImages.put(id,  image);
		names.put(id,  name);
	}
	
	
	public String getName(Integer id) {
		return names.get(id);
				}
	
	public BufferedImage getImage(String name) {
		return images.get(name);
	}
	
	public BufferedImage getImage(Integer in) {
		return idImages.get(in);
	}
	
	
	public Map<String, BufferedImage> getImages() {
		return images;
	}
	
	public Map<Integer, BufferedImage> getIdImages(){
		return idImages;
	}
}
