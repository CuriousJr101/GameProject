package com.ChoreQuest;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.ChoreQuest.Graphic.Screen;
import com.ChoreQuest.Graphic.Tile;
import com.ChoreQuest.KeyboardInputs.Keyboard;
import com.ChoreQuest.Levels.Level;
import com.ChoreQuest.Levels.PickUpLaundry.Level1_BillyRoom;

public class Game extends Canvas implements Runnable{
	public final int WIDTH = 350;
	public final int HEIGHT = WIDTH / 16 * 9;
	public final int SCALE = 3;
	public int x, y;
	
	public Thread thread;
	public boolean running;
	public JFrame frame;
	public Screen screen;
	public Keyboard key;
	public Tile tile;
	public Level level;
	public BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void terminate(){
		running = false;
		try{
			thread.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public Game(){
		Dimension d = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(d);
		frame = new JFrame();
		screen = new Screen(WIDTH, HEIGHT);
		level = new Level1_BillyRoom("/ChoreQuest/Level1-Billy's Room.png");
		key = new Keyboard();
		addKeyListener(key);
	}

	public void run() {
		while(running){
			update();
			render();
		}
	}

	public void update() {
		key.update();
		if(key.up) y--;
		if(key.down) y++;
		if(key.left) x--;
		if(key.right) x++;
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		level.render(x, y, screen);
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics graphics = bs.getDrawGraphics();
		graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		graphics.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.frame.setVisible(true);
		g.frame.add(g);
		g.frame.pack();
		g.frame.setResizable(false);
		g.frame.setLocationRelativeTo(null);
		g.frame.setFocusable(true);
		g.frame.setTitle("Chore Quest");
		g.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g.start();
	}
}
