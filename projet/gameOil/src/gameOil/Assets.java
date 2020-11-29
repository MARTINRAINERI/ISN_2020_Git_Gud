package gameOil;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width=20, height=20;
	public static BufferedImage player, Trap, luck,obstacle, grass, teleport,begin,end;
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/imgpsh_mobile_save.jpg"));
		player=sheet.crop(0,0,width,height);
		Trap=sheet.crop(width,0,width,height);
		luck=sheet.crop(width*2,0,width,height);
		obstacle=sheet.crop(width*3,0,width,height);
		grass=sheet.crop(width*4,0,width,height);
		teleport=sheet.crop(width*5,0,width,height);
		begin=sheet.crop(width*6,0,width,height);
		end=sheet.crop(width*7,0,width,height);
	}

}
