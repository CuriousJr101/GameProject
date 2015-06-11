package com.ChoreQuest.Graphic;

import java.util.Random;

public class Screen {
	public int width, height;
	public int[] pixels;
	public int counter;
	public int timer;
	public int xOffset, yOffset;
	public final int SIZE = 64;
	public int[] tiles = new int[SIZE * SIZE];
	public Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}
	
	public void renderTile(int xPosition, int yPosition, Tile tile){
		int yAbsolutePosition;
		int xAbsolutePosition;
		xPosition -= xOffset;
		yPosition -= yOffset;
		for(int y = 0; y < tile.sprite.SIZE; y++){
			yAbsolutePosition = y + yPosition;
			for(int x = 0; x < tile.sprite.SIZE; x++){
				xAbsolutePosition = x + xPosition;
				if(xAbsolutePosition < -16 || xAbsolutePosition >= width || yAbsolutePosition < 0 || yAbsolutePosition >= height) break;
				if(xAbsolutePosition < 0) xAbsolutePosition = 0;
				pixels[xAbsolutePosition + yAbsolutePosition * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	
	public void offsets(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0x424242;
		}
	}
}
