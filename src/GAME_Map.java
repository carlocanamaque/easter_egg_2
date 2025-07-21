package src;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class GAME_Map{

	GAME_Processor processor;
	PARENT_Tile[] tiles;

	public GAME_Map(GAME_Processor processor) {

		this.processor = processor;

		tiles[0] = new PARENT_Tile();
		tiles[0] = Toolkit.getDefaultToolkit().createImage("res/TILE_Grass_1.gif");
		tiles[1] = new PARENT_Tile();
		tiles[1] = Toolkit.getDefaultToolkit().createImage("res/TILE_Grass_2.gif");
		tiles[2] = new PARENT_Tile();
		tiles[2] = Toolkit.getDefaultToolkit().createImage("res/TILE_Grass_3.gif");
	}

	public void draw(Graphics2D g2) {

		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;

		while(col < processor.MAX_SCREEN_COL && row < processor.MAX_SCREEN_ROW) {

			g2.drawImage(tiles[0], x, y, processor.TILE_SIZE, processor.TILE_SIZE, processor);
			x += processor.TILE_SIZE;
			col++;

			if(col == processor.MAX_SCREEN_COL) {

				x = 0;
				y += processor.TILE_SIZE;
				col = 0;
				row++;
			}
		} 
	}
}
