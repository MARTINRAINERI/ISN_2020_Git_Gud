package gameOil;

import java.awt.image.BufferedImage;

public class RockTile extends Tile {

	public RockTile( int id) {
		super(Assets.obstacle, id);
		// TODO Auto-generated constructor stub
	}
	//overwritten for collision
	public boolean isSolid() {
		return true;

}
}
