package com.ChoreQuest.Graphic.Tiles;

import com.ChoreQuest.Graphic.Screen;
import com.ChoreQuest.Graphic.Sprite;
import com.ChoreQuest.Graphic.Tile;

public class coloredFloor extends Tile{

	public coloredFloor(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, Tile.coloredTile);
	}
}
