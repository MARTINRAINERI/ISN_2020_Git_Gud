package gameOil;

import java.awt.Graphics;

public class Player extends Creature {

	public Player(Game game,float x, float y) {
		super(game,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
	}

	@Override
	public void tick() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
	}
	private void getInput() {
		xMove=0;
		yMove=0;
		if(game.getKeyManager().up)
			yMove=-speed;
		if(game.getKeyManager().down)
			yMove=speed;
		if(game.getKeyManager().left)
			xMove=-speed;
		if(game.getKeyManager().right)
			xMove=speed;
		if(game.getKeyManager().up & game.getKeyManager().down) {
			yMove=0;
		}
		if(game.getKeyManager().left & game.getKeyManager().right) {
			xMove=0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)(x-game.getGameCamera().getXoffset()),(int)(y-game.getGameCamera().getYoffset()),width,height,null);
	}

}
