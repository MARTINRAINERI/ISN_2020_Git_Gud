package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test_Labyrinth {
	Labyrinthe test = new Labyrinthe("levels/1.txt");

	
	@Test
	void test_nbhauteur() {
		assertSame(10,test.getNb_hauteur());
	}
	
	
	@Test
	void test_nblargeur() {
		assertSame(10,test.getNb_largeur());
	}
	
	
	@Test
	void test_nbcase() {
		assertSame(100,test.getNb_case());
	}
	
	
	@Test
	void test_tilelength() {
		assertSame(test.getTile_length(),32);
	}
	
	
	@Test
	void test_timelimit() {
		assertSame(60,test.getTime_Limit());
	}
	
	
	//@Test
	//void test_dimensions() {

	//}
	
	
	//@Test
	//void test_caracteres() {

	//}
}
