package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test_PacmanGame {
	Labyrinthe donjon = new Labyrinthe("levels/1.txt");
	Pacman heros = new Pacman(donjon.spawn);
	Monster[] monstres = new Monster[donjon.spawnMonsters.size()];
	MainPainter painter = new MainPainter(heros,donjon,monstres);
	PacmanGame test=new PacmanGame("levels/1.txt",heros,donjon,monstres);

	@Test
	void test_isgameover() {
		assertSame(true,test.isGameOver(61));
		assertNotSame(true,test.isGameOver(59));
	}
	
	
	@Test
	void test_isFinished() {
		assertSame(false,test.isFinished());
	}
	
	
	
	//@Test
	//void test_iskilled() {
	//	assertSame(true,test.isKilled());
	//}

}
