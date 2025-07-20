package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;


public class GAME_Processor extends JPanel implements Runnable {

	final int ORIG_TILE_SIZE = 16;
	final int TILE_SIZE_SCALE_RATE = 3;
	final int TILE_SIZE = (ORIG_TILE_SIZE * TILE_SIZE_SCALE_RATE);

	final int MAX_SCREEN_COL = 16;
	final int MAX_SCREEN_ROW = 12;
	final int SCREEN_WIDTH = (TILE_SIZE * MAX_SCREEN_COL);
	final int SCREEN_HEIGHT = (TILE_SIZE * MAX_SCREEN_COL);

	final int FRAME_RATE_PER_SEC = 60;

	// TO-DO: code here...

	Thread thread;
	
	public GAME_Processor() {

		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
	}
	void startThread() {

		thread = new Thread(this);
		thread.start();
	}
	void update() {

		// TO-DO: code here...
	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// TO-DO: code here...

		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("linux")) {
			Toolkit.getDefaultToolkit().sync();
		}

		g2.dispose();
	}
	@Override
	public void run() {

		double drawInterval = 1000000000/FRAME_RATE_PER_SEC;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (thread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;

			if (delta >= 1) {

				update();
				repaint();
				delta--;
			}
		}
	}
}


