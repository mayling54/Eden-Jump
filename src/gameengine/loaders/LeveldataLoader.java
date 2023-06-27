package gameengine.loaders;

import java.io.BufferedReader;
import java.io.FileReader;

import gamelogic.level.Leveldata;

public class LeveldataLoader {

	public static Leveldata loadLeveldata(String filePath) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		int width = Integer.parseInt(bufferedReader.readLine().split("=")[1]);
		int height = Integer.parseInt(bufferedReader.readLine().split("=")[1]);
		int tileSize = Integer.parseInt(bufferedReader.readLine().split("=")[1]) * 2;
		int[][] values = new int[width][height];
		
		for (int y = 0; y < height; y++) {
			String[] valuesAsString = bufferedReader.readLine().split(",");
			for (int x = 0; x < width; x++) {
				values[x][y] = Integer.parseInt(valuesAsString[x]);	
			}
		}
		String[] playerPos = bufferedReader.readLine().split("=")[1].split(",");
		int playerX = Integer.parseInt(playerPos[0]);
		int playerY = Integer.parseInt(playerPos[1]);
		bufferedReader.close();

		Mapdata mapdata = new Mapdata(width, height, tileSize, values);
		Leveldata leveldata = new Leveldata(mapdata, playerX, playerY);
		
		return leveldata;
	}
	
}
