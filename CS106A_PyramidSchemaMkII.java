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
	private final int BRICKS_IN_BASE = 14;
	private GPoint BASE_ORIGIN;
	
	public void run()
	{ 
		//canvas undefined until run()
		BASE_ORIGIN = new GPoint((getWidth() / 2), getHeight() - BRICK_HEIGHT);
		println("canvas width = " + getWidth()/2 + "canvas height = " + (getHeight() - 12));
		createPyramid();
		println("donezo");
	}
	
	
	private void createPyramid()
	{	
		//x = j, y = i
		for (int i = 0; i < BRICKS_IN_BASE; i++) { //always as high as it is long
			int bricksInRow = BRICKS_IN_BASE - i;
			for (int j = 0; j < bricksInRow; j++) {
				
				GPoint rowOrigin = new GPoint(
						BASE_ORIGIN.getX() - ((bricksInRow * BRICK_WIDTH) / 2),
						//BASE_ORIGIN.getY() - (i * BRICK_HEIGHT) //this worked but pyr. lvls were spaced apart
						//BASE_ORIGIN.getY() - i //this worked but pyr. was too smushed together
						BASE_ORIGIN.getY() - BRICK_WIDTH 
				);
				
				GRect newBrick = new GRect(
						rowOrigin.getX() + (j * BRICK_WIDTH),
						rowOrigin.getY() - (i * BRICK_HEIGHT), 
						BRICK_WIDTH, 
						BRICK_HEIGHT
				);
				
				add(newBrick);
			}
		}
	}
}