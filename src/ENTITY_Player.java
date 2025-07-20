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

		up = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_up.gif");
		down = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_down.gif");
		left = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_left.gif");
		right = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_right.gif");
		upleft = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_upleft.gif");
		upright = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_upright.gif");
		downleft = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_downleft.gif");
		downright = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_downright.gif");
	}
	public void update() {
		int nextX = x;
		int nextY = y;

		if (input.wPressed && input.aPressed) {
			direction = "upleft";
			nextX -= speed;
			nextY -= speed;
		} else if (input.wPressed && input.dPressed) {
			direction = "upright";
			nextX += speed;
			nextY -= speed;
		} else if (input.sPressed && input.aPressed) {
			direction = "downleft";
			nextX -= speed;
			nextY += speed;
		} else if (input.sPressed && input.dPressed) {
			direction = "downright";
			nextX += speed;
			nextY += speed;
		} else if (input.wPressed) {
			direction = "up";
			nextY -= speed;
		} else if (input.aPressed) {
			direction = "left";
			nextX -= speed;
		} else if (input.sPressed) {
			direction = "down";
			nextY += speed;
		} else if (input.dPressed) {
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
