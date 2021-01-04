package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test_MainPainter {
	Labyrinthe donjon = new Labyrinthe("levels/1.txt");
	Pacman heros = new Pacman(donjon.spawn);
	Monster[] monstres = new Monster[donjon.spawnMonsters.size()];
	MainPainter painter = new MainPainter(heros,donjon,monstres);

	@Test
	void test_width() {
		System.out.println(painter.getWidth());
		assertEquals(painter.getWidth(),320);
	}
	
	
	@Test
	void test_heigth() {
		System.out.println(painter.getWidth());
		assertEquals(painter.getHeight(),320);
	}

}
