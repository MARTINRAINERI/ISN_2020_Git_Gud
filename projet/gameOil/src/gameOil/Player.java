package gameOil;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Creature {

	public Player(Handler handler,float x, float y) {
		super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x=20;
		bounds.y=20;
		bounds.width=20;
		bounds.height=30;
		
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	private void getInput() {
		xMove=0;
		yMove=0;
		if(handler.getKeyManager().up)
			yMove=-speed;
		if(handler.getKeyManager().down)
			yMove=speed;
		if(handler.getKeyManager().left)
			xMove=-speed;
		if(handler.getKeyManager().right)
			xMove=speed;
		if(handler.getKeyManager().up & handler.getKeyManager().down) {
			yMove=0;
		}
		if(handler.getKeyManager().left & handler.getKeyManager().right) {
			xMove=0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)(x-handler.getGameCamera().getXoffset()),(int)(y-handler.getGameCamera().getYoffset()),width,height,null);
		
	}

}
