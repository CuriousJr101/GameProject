package com.ChoreQuest.Graphic;

import com.ChoreQuest.Graphic.Tiles.coloredFloor;
import com.ChoreQuest.Graphic.Tiles.legoWall1;
import com.ChoreQuest.Graphic.Tiles.smallWoodenBoard;

public class Tile {
	
	public Sprite sprite;
	public boolean isSolid = false;
	
	public static Tile coloredTile = new coloredFloor(Sprite.floorTile1);
	public static Tile legoWall1 = new legoWall1(Sprite.legoWallAssociatedWithFloorTile1);
	public static Tile smallWoodenBoard = new smallWoodenBoard(Sprite.smallWoodenBoards);
		
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean isSolid(){
		return isSolid;
	}
}
