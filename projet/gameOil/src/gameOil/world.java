package gameOil;

import java.awt.Graphics;

public class world {
	private Handler handler;
	private int width,height;
	private int spawnx, spawny ;
	private int[][] tiles;
	
	public world(Handler handler,String path) {
		this.handler=handler;
		loadworld(path);
		
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		int xStart =(int)Math.max(0, handler.getGameCamera().getXoffset()/Tile.TILEWIDTH);
		int xEnd=(int)Math.min(width, (handler.getGameCamera().getXoffset()+handler.getWidth())/Tile.TILEWIDTH+1);
		int yStart=(int) Math.max(0, handler.getGameCamera().getYoffset()/Tile.TILEHEIGHT);
		int yEnd=(int)Math.min(height, (handler.getGameCamera().getYoffset()+handler.getHeight())/Tile.TILEHEIGHT+1);
		
		for(int y=yStart; y<yEnd;y++) {
			for(int x=xStart; x<xEnd; x++) {
				getTile(x,y).render(g,(int)( x*Tile.TILEWIDTH-handler.getGameCamera().getXoffset()),(int)( y*Tile.TILEHEIGHT-handler.getGameCamera().getYoffset()));
				
			}
		}
		
	}
	public Tile getTile(int x, int y) {
		if(x<0 || y<0 || x>=width || y>=height)
			return Tile.grassTile;
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


