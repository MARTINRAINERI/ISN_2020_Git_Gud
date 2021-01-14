package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import graphics.SpriteSheet;

public class trap extends GameObject {
	
	private BufferedImage trap_image;
	
	public trap(int x, int y, ID id,  SpriteSheet ss) {
		super(x, y, id, ss);
		size=32;
		trap_image = ss.grabImage(7, 1, size, size);  
	}
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(trap_image, (int)x,(int) y, null); 
	}

	
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, size, size);
	}

	
	public Rectangle getbounds2() {
		// TODO Auto-generated method stub
		return null;
	}

}