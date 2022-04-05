package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
//Inherits JPanel class so it has a bunch of functions
public class GamePanel extends JPanel implements Runnable {

// Screen Settings
	final int originalTileSize = 16; // 16x16 tile - Resolution of each sprite
	final int scale = 3; // Scales the tile so it can actually be seen on modern monitor resulutions
	
	final int tileSize = originalTileSize * scale; // This will be the actual size of each tile
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
	
	// Set Player default Postion
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
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
	
	// Core Game Loop
	@Override
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
				Thread.sleep((long) remainingTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		if (keyH.upPressed == true) {
			playerY -= playerSpeed;
		} else if (keyH.downPressed == true) {
			playerY += playerSpeed;
		} else if (keyH.leftPressed == true) {
			playerX -= playerSpeed;
		} else if (keyH.rightPressed == true) {
			playerX += playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g; // Uses Type Casting to convert Graphics to Graphics2D
		
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
	}
	
}
