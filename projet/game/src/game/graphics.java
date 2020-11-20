package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import javax.swing.JPanel;

public class graphics extends JPanel implements ActionListener{
	Choix b=new Choix();
	Choix a=new Choix();
	private int i;
	
	public Rectangle playmap1=new Rectangle(130,50,160,70);
	public Rectangle playmap2=new Rectangle(130,150,160,70);
	private map m;
	private Timer t=new Timer(25,this);
	
	public graphics() {
		System.out.println("BLA0");
		m=new map();
		t.start();
		
		
	}
	public void paint(Graphics g) {
		System.out.println("BLA1");
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		Font font0=new Font("arial",Font.BOLD,50);
		g.setFont(font0);
		g.setColor(Color.black);
		g.drawString("MAP1", 140, 100);
		g2d.draw(playmap1);
		g.drawString("MAP2", 140, 200);
		g2d.draw(playmap2);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int mx=e.getX();
				int my=e.getY();
				if(mx>=130 && mx<=290) {
					if(my>=50 && my<=120) {
						i=1;
						a.setValeur(1);;
					}
				}
				if(mx>=130 && mx<=290) {
					if(my>=150 && my<=220) {
						i=1;
						a.setValeur(2);
					}
				}
			}
			
		});
		if(i==1) {
			for(int y=0;y<20;y++) {
				for(int x=0;x<20;x++) {
					if(m.getMap(x,y).equals("g")) {
						g.drawImage(m.getGrass(),x*20,y*20,null);
					}
					if(m.getMap(x,y).equals("w")) {
						g.drawImage(m.getWall(),x*20,y*20,null);
					}
					if(m.getMap(x,y).equals("t")) {
						g.drawImage(m.getTrap(),x*20,y*20,null);
					}
					if(m.getMap(x,y).equals("a")) {
						g.drawImage(m.getArrivee(),x*20,y*20,null);
					}
					if(m.getMap(x,y).equals("b")) {
						g.drawImage(m.getTeleport(),x*20,y*20,null);
					}
					if(m.getMap(x,y).equals("m")) {
						g.drawImage(m.getMagique(),x*20,y*20,null);
					}
					if(m.getMap(x,y).equals("p")) {
						g.drawImage(m.getPassage(),x*20,y*20,null);
					}
				}
					
			}
		}
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	
	}
