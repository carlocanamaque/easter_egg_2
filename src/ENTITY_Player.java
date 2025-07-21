package src;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class ENTITY_Player extends PARENT_Entity {

	GAME_Processor processor;
	GAME_Input input;

	Image up_hit, down_hit, left_hit, right_hit, upleft_hit, upright_hit,
	downleft_hit, downright_hit, up_throw, down_throw, left_throw, right_throw,
	upleft_throw, upright_throw, downleft_throw, downright_throw;

	public ENTITY_Player(GAME_Processor processor, GAME_Input input) {

		this.processor = processor;
		this.input = input;

		setDefaultValues();
	}
	void setDefaultValues() {

		x = 100;
		y = 100;
		direction = "down";

		up = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_up.gif");
		down = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_down.gif");
		left = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_left.gif");
		right = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_right.gif");
		upleft = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_upleft.gif");
		upright = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_upright.gif");
		downleft = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_downleft.gif");
		downright = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_downright.gif");

		up_hit = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_up_hit.gif");
		down_hit = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_down_hit.gif");
		left_hit = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_left_hit.gif");
		right_hit = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_right_hit.gif");
		upleft_hit = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_upleft_hit.gif");
		upright_hit = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_upright_hit.gif");
		downleft_hit = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_downleft_hit.gif");
		downright_hit = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_downright_hit.gif");

		up_throw = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_up_throw.gif");
		down_throw = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_down_throw.gif");
		left_throw = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_left_throw.gif");
		right_throw = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_right_throw.gif");
		upleft_throw = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_upleft_throw.gif");
		upright_throw = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_upright_throw.gif");
		downleft_throw = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_downleft_throw.gif");
		downright_throw = Toolkit.getDefaultToolkit().createImage("res/ENTITY_Player_downright_throw.gif");
	}
	void update() {

		if(input.spacePressed) {
			speed = 6;
		} else {
			speed = 4;
		}

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
	void draw(Graphics2D g2) {

		Image gif = null;

		switch (direction) {
			case "up":
				gif = up;
				if(input.kPressed) {
					gif = up_hit;
				}
				if(input.pPressed) {
					g2.drawImage(up_throw, x, (y-(2*processor.TILE_SIZE)),
					processor.TILE_SIZE, (2*processor.TILE_SIZE), processor);
				}
				break;
			case "left":
				gif = left;
				if(input.kPressed) {
					gif = left_hit;
				}
				if(input.pPressed) {
					g2.drawImage(left_throw, (x-(2*processor.TILE_SIZE)), y,
					(2*processor.TILE_SIZE), processor.TILE_SIZE, processor);
				}
				break;
			case "down":
				gif = down;
				if(input.kPressed) {
					gif = down_hit;
				}
				if(input.pPressed) {
					g2.drawImage(down_throw, x, (y+processor.TILE_SIZE),
					processor.TILE_SIZE, (2*processor.TILE_SIZE), processor);
				}
				break;
			case "right":
				gif = right;
				if(input.kPressed) {
					gif = right_hit;
				}
				if(input.pPressed) {
					g2.drawImage(right_throw, (x+processor.TILE_SIZE), y,
					(2*processor.TILE_SIZE), processor.TILE_SIZE, processor);
				}
				break;
			case "upleft":
				gif = upleft;
				if(input.kPressed) {
					gif = upleft_hit;
				}
				if(input.pPressed) {
					g2.drawImage(upleft_throw, (x-(2*processor.TILE_SIZE)),
					(y-(2*processor.TILE_SIZE)), (2*processor.TILE_SIZE),
					(2*processor.TILE_SIZE), processor);
				}
				break;
			case "upright":
				gif = upright;
				if(input.kPressed) {
					gif = upright_hit;
				}
				if(input.pPressed) {
					g2.drawImage(upright_throw, (x+processor.TILE_SIZE),
					(y-(2*processor.TILE_SIZE)), (2*processor.TILE_SIZE),
					(2*processor.TILE_SIZE), processor);
				}
				break;
			case "downleft":
				gif = downleft;
				if(input.kPressed) {
					gif = downleft_hit;
				}
				if(input.pPressed) {
					g2.drawImage(downleft_throw, (x-(2*processor.TILE_SIZE)),
					(y+processor.TILE_SIZE), (2*processor.TILE_SIZE),
					(2*processor.TILE_SIZE), processor);
				}
				break;
			case "downright":
				gif = downright;
				if(input.kPressed) {
					gif = downright_hit;
				}
				if(input.pPressed) {
					g2.drawImage(downright_throw, (x+processor.TILE_SIZE),
					(y+processor.TILE_SIZE), (2*processor.TILE_SIZE),
					(2*processor.TILE_SIZE), processor);
				}
				break;
		}

		g2.drawImage(gif, x, y, processor.TILE_SIZE, processor.TILE_SIZE, processor);
	}
}
