package com.ChoreQuest;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	public final int LENGTH = 300;
	public final int WIDTH = (16/9) * LENGTH;
	public final int SCALE = 3;
	
	public Thread thread;
	public boolean running;
	public JFrame frame;
	
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
		Dimension d = new Dimension(WIDTH * SCALE, LENGTH * SCALE);
		setPreferredSize(d);
		frame = new JFrame();
	}

	public void run() {
		while(running){
			update();
			render();
		}
	}

	private void update() {
		
	}

	private void render() {
		
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
