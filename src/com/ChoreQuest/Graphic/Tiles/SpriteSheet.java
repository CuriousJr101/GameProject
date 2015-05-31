package com.ChoreQuest.Graphic.Tiles;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	public int[] pixels;
	public String path;
	public final int SIZE;
	static String path1 = "/ChoreQuest/SpriteSheet.png";
	
	public static SpriteSheet sheet1 = new SpriteSheet(256, path1);
	
	public SpriteSheet(int s, String a){
		SIZE = s;
		pixels = new int[SIZE * SIZE];
		path = a;
		load();
	}
	
	public void load(){
		try {
			BufferedImage image = (BufferedImage) ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w); // Sets the pixels to the image
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
