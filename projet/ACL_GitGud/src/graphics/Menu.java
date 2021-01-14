	package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import graphics.Game.STATE;
import objects.*;



public class Menu extends MouseAdapter{

	private Game game;
	private BufferedImageLoader loader;
	public Menu(Game game) {
		this.game=game;
		this.loader = new BufferedImageLoader();
	}


	public void mousePressed(MouseEvent e) {
		int mx =e.getX();
		int my=e.getY();


		//Play button
		if(game.gameState==STATE.Menu) {
			if(mouseOver(mx,my,400,200,200,64)) {
				game.gameState=STATE.init;
				game.init_game();
			}
		}

		//Quit button
		if(mouseOver(mx,my,400,400,200,64)) {
			System.exit(1);
		}

		//Help button
		if(game.gameState==STATE.Menu) {
			if(mouseOver(mx,my,400,300,200,64)) {
				game.gameState=STATE.Help;
			}
		}

		//Back button for help
		if(game.gameState==STATE.Help) {
			if(mouseOver(mx,my,400,450,200,64)) {
				game.gameState=STATE.Menu;
			}
		}

		if(game.gameState==STATE.GameOver) {
			if(mouseOver(mx,my,380, 260, 240, 64)) {
				game.gameState=STATE.init;
				game.init_game();
			}
			if (mouseOver(mx,my,380, 360, 240, 64)) {
				game.gameState=STATE.Menu;
			}
		}
		if(game.gameState==STATE.GameWon) {
			if(mouseOver(mx,my,380, 260, 240, 64)) {
				game.gameState=STATE.init;
				game.init_game();
			}
			if (mouseOver(mx,my,380, 360, 240, 64)) {
				game.gameState=STATE.Menu;
			}
		}
	}

	public void MouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my,int x, int y,int width, int height) {
		if (mx > x && mx < x+width) {
			if(my>y && my<y+height) {
				return true;
			}else return false;
		}else return false;
	}


	public void tick() {

	}

	public void render(Graphics g) {
		if(game.gameState ==STATE.Menu) {
			BufferedImage logo = loader.loadImage("/Zgames.png");
			
			Font fnt=new Font("arial",1,20);
			Font fnt1=new Font("arial",1,30);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.drawImage(logo, 300,-10 , null);
			g.setColor(Color.WHITE);
			g.setFont(fnt1);
			g.drawRect(400, 200, 200, 64);
			g.drawString("Jouer", 460, 240);

			g.drawRect(400, 300, 200, 64);
			g.drawString("Aide", 470, 340);

			g.drawRect(400, 400, 200, 64);
			g.drawString("Quitter", 460, 440);

		}else if(game.gameState ==STATE.init) {
			Font fnt=new Font("Courier",1,50);
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("loading", 400, 170);
		}
		else if(game.gameState ==STATE.Help) {
			Font fnt=new Font("arial",1,50);
			Font fnt1=new Font("arial",1,30);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Aide", 430, 90);

			g.setFont(fnt1);
			g.drawString("Lancez le jeu",60,130);
			g.drawString("Déplacez votre héros à l'aide des flèches de votre clavier",60,180)	;	
			g.drawString("Ramassez les armes pour tuer les monstres en cliquant vers eux ",60,230)	;		 
			g.drawString("Utilisez les coeurs pour remplir votre jauge de PV ",60,280);
			g.drawString("Accédez au coffre pour gagner",60,330);
			g.drawString("Evitez les monstres et les cases pièges",60,380);



			g.setFont(fnt1);
			g.drawRect(400, 450, 200, 64);
			g.drawString("Quittez", 460, 490);
		}
		else if(game.gameState ==STATE.GameOver) {

			Font fnt=new Font("arial",1,50);
			Font fnt1=new Font("arial",1,30);
			Font fnt2=new Font("arial",1,20);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("Vous avez perdu avec un score de "+HUD.score+" !", 340, 200);

			g.setFont(fnt1);
			g.drawRect(380, 260, 240, 64);
			g.drawString("Réessayer", 430, 300);

			g.drawRect(380, 360, 240, 64);
			g.drawString("Quitter", 460, 400);

		}
		else if(game.gameState ==STATE.GameWon) {

			Font fnt=new Font("arial",1,50);
			Font fnt1=new Font("arial",1,30);
			Font fnt2=new Font("arial",1,20);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawString("Vous avez gagné avec un score de "+HUD.score+" !", 340, 200);

			g.setFont(fnt1);
			g.drawRect(380, 260, 240, 64);
			g.drawString("Rejouer", 440, 300);

			g.drawRect(380, 360, 240, 64);
			g.drawString("Menu", 460, 400);

		}

	}

}