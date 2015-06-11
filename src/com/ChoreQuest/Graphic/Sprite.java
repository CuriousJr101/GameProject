package com.ChoreQuest.Graphic;

public class Sprite {
	
	public int x, y;
	public final int SIZE;
	public int[] pixels;
	public SpriteSheet sheet;
	
	public static Sprite floorTile1 = new Sprite(16, 1, 1, SpriteSheet.sheet1);
	public static Sprite legoWallAssociatedWithFloorTile1 = new Sprite(16, 1, 2, SpriteSheet.sheet1);
	public static Sprite smallWoodenBoards = new Sprite(16, 2, 1, SpriteSheet.sheet1);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
