package gameOil;

import java.awt.Graphics;

public class GameState extends State {
	private Player player;
	private world world;
	public GameState(Game game) {
		super(game);
		player= new Player(game,100,100);
		world= new world(game,"world1.txt");
		
		
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		
		
		
		
	}

}
