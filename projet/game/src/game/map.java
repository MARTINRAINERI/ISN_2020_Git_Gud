package game;

import java.awt.Image;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class map {
	
	Choix b=new Choix();
	Choix a=new Choix();
	
	private Scanner m;
	private String Map[]=new String[20];
	private Image grass,wall,trap,arrivee,teleport,magique,passage;
	
	
	public map() {
		System.out.println("BLA4");
		ImageIcon img=new ImageIcon(getClass().getResource("/images/grass.png"));
		grass=img.getImage();
		img = new ImageIcon(getClass().getResource("/images/wall.png"));
		wall=img.getImage();
		img = new ImageIcon(getClass().getResource("/images/trap.png"));
		trap=img.getImage();
		img = new ImageIcon(getClass().getResource("/images/trap.png"));
		trap=img.getImage();
		arrivee=img.getImage();
		img = new ImageIcon(getClass().getResource("/images/arrivee.png"));
		arrivee=img.getImage();
		teleport=img.getImage();
		img = new ImageIcon(getClass().getResource("/images/teleport.png"));
		teleport=img.getImage();
		magique=img.getImage();
		img = new ImageIcon(getClass().getResource("/images/magique.png"));
		magique=img.getImage();
		passage=img.getImage();
		img = new ImageIcon(getClass().getResource("/images/passage.png"));
		passage=img.getImage();
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getGrass() {
		return grass;
	}
	
	public Image getWall() {
		return wall;
	}
	
	public Image getTrap() {
		return trap;
	}
	public Image getArrivee() {
		return arrivee;
	}
	public Image getTeleport() {
		return teleport;
	}
	public Image getMagique() {
		return magique;
	}
	public Image getPassage() {
		return passage;
	}
	
	public String getMap(int x,int y) {
		String index=Map[y].substring(x,x+1);
		return index;
	}
	
	public void openFile() {
		System.out.println("BLA2");
		try {
			b.setValeur(1);
			if(b.getValeur()==1) {
				m=new Scanner(new File("C://Users//Bruno//Desktop/map.txt"));
			}
			if(b.getValeur()==2) {
				m=new Scanner(new File("C://Users//Bruno//Desktop/map2.txt"));
			}
		}catch(Exception e)
		{
			System.out.println("Erreur chargement labyrinthe");
		}
	}
	
	public void readFile() {
		while(m.hasNext()) {
			for(int i=0;i<20;i++) {
				Map[i]=m.next();
				
			}
		}
		
	}
	
	public void closeFile() {
		m.close();
		System.out.println("BLA3");
		
	}

}
