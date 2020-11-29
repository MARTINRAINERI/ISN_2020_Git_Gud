package gameOil;

import java.awt.Graphics;

public class world {
	private Game game;
	private int width,height;
	private int spawnx, spawny ;
	private int[][] tiles;
	
	public world(Game game,String path) {
		this.game=game;
		loadworld(path);
		
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		int xStart =(int)Math.max(0, game.getGameCamera().getXoffset()/Tile.TILEWIDTH);
		int xEnd=(int)Math.min(width, (game.getGameCamera().getXoffset()+game.getWidth())/Tile.TILEWIDTH+1);
		int yStart=(int) Math.max(0, game.getGameCamera().getYoffset()/Tile.TILEHEIGHT);
		int yEnd=(int)Math.min(height, (game.getGameCamera().getYoffset()+game.getHeight())/Tile.TILEHEIGHT+1);
		
		for(int y=yStart; y<yEnd;y++) {
			for(int x=xStart; x<xEnd; x++) {
				getTile(x,y).render(g,(int)( x*Tile.TILEWIDTH-game.getGameCamera().getXoffset()),(int)( y*Tile.TILEHEIGHT-game.getGameCamera().getYoffset()));
				
			}
		}
		
	}
	public Tile getTile(int x, int y) {
		Tile t= Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.rockTile;
		return t;
	}
	private void loadworld(String path) {
		String file = utils.loadFileAsString(path);
		String[] tokens= file.split("\\s+");
		width=utils.parseInt(tokens[0]);
		height=utils.parseInt(tokens[1]);
		spawnx=utils.parseInt(tokens[2]);
		spawny=utils.parseInt(tokens[3]);
		tiles= new int[width][height];
		for(int y=0; y<height;y++ ) {
			for(int x=0; x<width;x++) {
				try {
					tiles[x][y]=utils.parseInt(tokens[(x+y*width)+4]);
				} catch (Exception e) {
					System.out.println("Les dimensions entrées sont incohérentes avec le tableau, veuillez choisir des dimensions intelligentes");
					System.exit(0);
				}
			}
		}
	
		
	}

}


