package gameOil;

import java.awt.*;
import java.awt.image.*;

public class Game  implements Runnable{
	private Display display;
	private int width, height;
	private Thread thread;
	public String title;
	private boolean running = false;
	private BufferStrategy bs ;
	private Graphics g;
	//States
	private State gameState;
	private State menuState;
	// Input
	private MouseManager mouseManager;
	private KeyManager keyManager;
	//Camera
	private GameCamera gameCamera;
	//Handler
	private Handler handler;
	
	
	public Game(String title, int width, int height) {
		this.width= width;
		this.height=height;
		this.title=title;
		keyManager=new KeyManager();
		mouseManager= new MouseManager();
	}
	
	private void init() {
		display= new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		gameCamera= new GameCamera(this,0,0);
		handler = new Handler(this);
		gameState= new GameState(handler);
		menuState= new MenuState(handler);
		State.setState(gameState);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		
	}
	private void tick() {
		keyManager.tick();
		if(State.getState()!=null)
			State.getState().tick();
		
	}
	private void render() {
		bs= display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
			
		}
		g= bs.getDrawGraphics();
		//clear screen
		g.clearRect(0,0,width,height);
		//Draw Here!
		if(State.getState()!=null)
			State.getState().render(g);
		
		// End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		int fps=60;
		double timePerTick=1000000000/fps;
		double delta=0;
		long now;
		long lastTime=System.nanoTime();
		long timer=0;
		int ticks=0;
		while(running) {
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTick;
			timer+=now-lastTime;
			lastTime=now;
			if(delta>=1) {
				tick();
				render();
				ticks++;
				delta--;
				
			}
			if (timer>=1000000000) {
				ticks=0;
				timer=0;
			}
		}
		stop();
		
	}
	public KeyManager getKeyManager() {
		return keyManager;
	}
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public synchronized void start() {
		if(running)
			return;
		running= true;
		thread= new Thread(this);
		thread.start();
		
	}
    public synchronized void stop() {
    	if(!running)
    		return;
    	running=false;
    	try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public MouseManager getMouseManager() {
    	return mouseManager;
    }

}
