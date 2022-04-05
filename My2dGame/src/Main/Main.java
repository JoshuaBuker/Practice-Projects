package Main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
	// Create the window	
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows window to close properly on ("x") button click
		window.setResizable(false); // Window will stay same size
		window.setTitle("2D Adventure"); // Sets title of the window
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		
		window.setLocationRelativeTo(null); // By setting value to null, it defaults to setting screen to center
		window.setVisible(true); // Allows window to be seen
		
		gamePanel.startGameThread();
	}

}
