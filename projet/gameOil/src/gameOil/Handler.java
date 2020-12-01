package gameOil;

public class Handler {
	private Game game;
	private world world;
	public Game getGame() {
		return game;
	}
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public int getWidth() {
		return game.getWidth();
	}
	public int getHeight() {
		return game.getHeight();
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public world getWorld() {
		return world;
	}
	public void setWorld(world world) {
		this.world = world;
	}
	public Handler( Game game) {
		
		this.game=game;
	}

}
