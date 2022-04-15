package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
//Inherits JPanel class so it has a bunch of functions
public class GamePanel extends JPanel implements Runnable {

// Screen Settings
	final int originalTileSize = 16; // 16x16 tile - Resolution of each sprite
	final int scale = 3; // Scales the tile so it can actually be seen on modern monitor resulutions
	
	public final int tileSize = originalTileSize * scale; // This will be the actual size of each tile
	final int maxScreenCol = 16; // 16 Horizonal Tiles
	final int maxScreenRow = 12; // 12 Vertical Tiles
	// BTW this is a 4:3 aspect ratio
	final int screenWidth = tileSize * maxScreenCol;  // 768
	final int screenHeight = tileSize * maxScreenRow; // 576
	// Resolution is 768x576
	
	
	// FPS 
	int FPS = 60;
	
	// Keep Program Running
	Thread gameThread;
	
	// Adds key reconizion
	KeyHandler keyH = new KeyHandler();
	
	Player player = new Player(this,keyH);
	
	
	// Game Panel Constructor 
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Screen Resolution
		this.setBackground(Color.black); // Background Color
		this.setDoubleBuffered(true); // Allows better rendering performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	// Starts Thread, which automatically runs the 'run' command and starts game loop
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
// Core Game Loop  - Method 1
/*	@Override
	public void run() {
	// Sets Game Loop Timer so it has only 60fps	
		double drawInterval = 1000000000/FPS; //0.01666 seconds 
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
		// 1 UPDATE: Update information such as character positons
			update();
		// 2 DRAW: Draw the screen with the updated information
			repaint(); // This calls the paintComponent function - Don't ask why
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				//Convert NanoSeconds to Miliseconds
				remainingTime = remainingTime / 1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
*/	
	
//Core Game Loop - Method 2
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			/*  Prints FPS to screen
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
			*/
		}
	}

	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g; // Uses Type Casting to convert Graphics to Graphics2D
		
		player.draw(g2);
		
		g2.dispose();
	}
	
}
