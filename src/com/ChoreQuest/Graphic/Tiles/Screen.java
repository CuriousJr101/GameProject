package com.ChoreQuest.Graphic.Tiles;

import java.util.Random;

public class Screen {
	public int width, height;
	public int[] pixels;
	public int counter;
	public int timer;
	public final int SIZE = 64;
	public int[] tiles = new int[SIZE * SIZE];
	public Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		for(int i = 0; i < SIZE * SIZE; i++){
			tiles[i] = random.nextInt(0x424242);
		}
	}
	
	public void render(int xMove, int yMove){
		for(int y = 0; y < height; y++){
			int yOffset = y + yMove;
			for(int x = 0; x < width; x++){
				int xOffset = x + xMove;
				int tileIndex = ((xOffset >> 4) & SIZE - 1) + ((yOffset >> 4) & SIZE - 1) * SIZE;
				pixels[x + y * width] = Sprite.floor.pixels[(x & 15) + (y & 15) * Sprite.floor.SIZE];
			}
		}
	}
	
	public void renderTile(){
		
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0x424242;
		}
	}
}
