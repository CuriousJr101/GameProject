package com.ChoreQuest.Graphic.Tiles;

import com.ChoreQuest.Graphic.Screen;
import com.ChoreQuest.Graphic.Sprite;
import com.ChoreQuest.Graphic.Tile;

public class legoWall1 extends Tile{

	public legoWall1(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, Tile.legoWall1);
	}

}
