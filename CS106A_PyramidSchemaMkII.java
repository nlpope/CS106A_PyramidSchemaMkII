/**
 * File: CS106A_PyramidSchemaMkII.java
 * ----------------------------
 * This Java program creates a pyramid.
 */

import java.awt.Color;
import acm.program.*;
import acm.graphics.*;

public class CS106A_PyramidSchemaMkII extends GraphicsProgram
{	
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 12;
	private int BRICKS_IN_BASE = 14;
	private int PYRAMID_HEIGHT = (BRICKS_IN_BASE) * BRICK_HEIGHT;
	//private GPoint BASE_ORIGIN = new GPoint((getWidth() / 2), getHeight() - BRICK_HEIGHT);
	private GPoint BASE_ORIGIN = new GPoint(getWidth(), getHeight());
	
	public void run()
	{ 
		println("BASE_ORIGIN = " + BASE_ORIGIN);
		createPyramid();
	}
	
	
	private void createPyramid()
	{
		int totalBricks = 0;
		int tmpBricks = BRICKS_IN_BASE;
		while (tmpBricks > 0) { 
			totalBricks += tmpBricks;
			tmpBricks -= 1;
		}

		while (totalBricks > 0) {
			for (int i = 0; i < PYRAMID_HEIGHT; i++) {
				int totalBricksInRow = BRICKS_IN_BASE - i;
				//PROBLEM CHILD
				GPoint rowOrigin = new GPoint(
						BASE_ORIGIN.getX() - (totalBricksInRow / 2),
						BASE_ORIGIN.getY() - i * BRICK_HEIGHT					
				);
				println("row origin = " + rowOrigin);
				println("");
				
				GRect newBrick = new GRect(
						rowOrigin.getX() + (i * BRICK_WIDTH), 
						rowOrigin.getY() - (i * BRICK_HEIGHT), 
						BRICK_WIDTH, 
						BRICK_HEIGHT
				);
				
				add(newBrick);
			}
			totalBricks--;
		}		
	}
}