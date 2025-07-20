package src;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class ENTITY_Player extends PARENT_Entity {

	GAME_Processor processor;
	GAME_Input input;

	public ENTITY_Player(GAME_Processor processor, GAME_Input input) {

		this.processor = processor;
		this.input = input;

		x = 100;
		y = 100;
		speed = 4;
		direction = "down";

		up = Toolkit.getDefaultToolkit().createImage("res/up.gif");
		down = Toolkit.getDefaultToolkit().createImage("res/down.gif");
		left = Toolkit.getDefaultToolkit().createImage("res/left.gif");
		right = Toolkit.getDefaultToolkit().createImage("res/right.gif");
		upleft = Toolkit.getDefaultToolkit().createImage("res/upleft.gif");
		upright = Toolkit.getDefaultToolkit().createImage("res/upright.gif");
		downleft = Toolkit.getDefaultToolkit().createImage("res/downleft.gif");
		downright = Toolkit.getDefaultToolkit().createImage("res/downright.gif");
	}
	public void update() {
		int nextX = x;
		int nextY = y;

		if (keyH.wPressed && keyH.aPressed) {
			direction = "upleft";
			nextX -= speed;
			nextY -= speed;
		} else if (keyH.wPressed && keyH.dPressed) {
			direction = "upright";
			nextX += speed;
			nextY -= speed;
		} else if (keyH.sPressed && keyH.aPressed) {
			direction = "downleft";
			nextX -= speed;
			nextY += speed;
		} else if (keyH.sPressed && keyH.dPressed) {
			direction = "downright";
			nextX += speed;
			nextY += speed;
		} else if (keyH.wPressed) {
			direction = "up";
			nextY -= speed;
		} else if (keyH.aPressed) {
			direction = "left";
			nextX -= speed;
		} else if (keyH.sPressed) {
			direction = "down";
			nextY += speed;
		} else if (keyH.dPressed) {
			direction = "right";
			nextX += speed;
		}

		if (nextX >= 0 && nextX <= (processor.SCREEN_WIDTH - processor.TILE_SIZE) &&
		    nextY >= 0 && nextY <= (processor.SCREEN_HEIGHT - processor.TILE_SIZE)) {
			x = nextX;
			y = nextY;
		}
	}

	public void draw(Graphics2D g2) {

		Image gif = null;

		switch (direction) {
			case "up":
				gif = up;
				break;
			case "left":
				gif = left;
				break;
			case "down":
				gif = down;
				break;
			case "right":
				gif = right;
				break;
			case "upleft":
				gif = upleft;
				break;
			case "upright":
				gif = upright;
				break;
			case "downleft":
				gif = downleft;
				break;
			case "downright":
				gif = downright;
				break;
		}

		g2.drawImage(gif, x, y, processor.TILE_SIZE, processor.TILE_SIZE, processor);
	}
}
