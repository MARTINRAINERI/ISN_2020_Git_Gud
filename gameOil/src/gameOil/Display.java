package gameOil;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Display {
	public Rectangle playmap1=new Rectangle(130,50,160,70);
	public Rectangle playmap2=new Rectangle(130,150,160,70);
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width,height;
	public Display(String title, int width, int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		createDisplay();
		
		}
	private void createDisplay() {
		frame= new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		canvas= new Canvas();
		canvas.setPreferredSize(new Dimension( width,height));
		canvas.setMaximumSize(new Dimension( width, height));
		canvas.setMinimumSize(new Dimension( width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
		
		
		
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() {
		return frame;
	}
	

}
