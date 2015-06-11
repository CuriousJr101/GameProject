package com.ChoreQuest.Levels;

import com.ChoreQuest.Graphic.Screen;
import com.ChoreQuest.Graphic.Tile;

public class Level {
	
	public int width, height;
	public int[] tiles;
	public int[] tilesInt;
	
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tilesInt = new int [width * height];
		generateLevel();
	}
	
	public void generateLevel() {
		
	}

	public Level(String path){
		loadLevel(path);
	}
	
	public void loadLevel(String path){
		
	}
	
	public void update(){
		
	}
	
	public void time(){
		
	}
	
	public void render(int xPlayerMovement, int yPlayerMovement, Screen screen){
		screen.offsets(xPlayerMovement, yPlayerMovement);
		int xLeftCornor = xPlayerMovement >> 4;
		int xRightCornor = (xPlayerMovement  + screen.width + 16) >> 4;
		int yLeftCornor = yPlayerMovement >> 4;
		int yRightCornor = (yPlayerMovement  + screen.height + 16) >> 4;
		for(int y = yLeftCornor; y < yRightCornor; y++){
			for(int x = xLeftCornor; x < xRightCornor; x++){
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || x >= width || y < 0 || y >= height) return Tile.smallWoodenBoard;
		if(tiles[x + y * width] == 0xFF000000) return Tile.coloredTile;
		if(tiles[x + y * width] == 0xFFFF0000) return Tile.legoWall1;
		return Tile.smallWoodenBoard;
	}
	
	//Black = FF000000 -> Sprite with wooden tile that has many different colors
	//Red = FFFF0000 -> The legowall that is associated with it
	
}
