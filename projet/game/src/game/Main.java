package game;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	

	private JFrame f;

	public static void main(String[] args) {
		System.out.println("BLA-3");
		new Main();
		
	}
	public Main() {
		f=new JFrame();
		f.setTitle("Git Gud");
		System.out.println("BLA-2");
		f.add(new graphics());
		System.out.println("BLA-1");
		f.setVisible(true);
		f.setSize(416,439);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	


	}
	

}
