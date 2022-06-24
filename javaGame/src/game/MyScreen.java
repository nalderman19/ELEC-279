package game;

import javax.swing.JFrame;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

//import sun.audio.*;


public class MyScreen extends JFrame {

	public MyScreen() {
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
		
	public static void main(String[] args) {
		MyScreen screen = new MyScreen();
		MyCanvas canvas = new MyCanvas();
		screen.getContentPane().add(canvas);
		screen.setBackground(Color.DARK_GRAY);
		playIt("theme.wav");
	}
	
	public static void playIt(String songname) {
		try {
			InputStream in = new FileInputStream("stuff/" + songname);
			//AudioStream as = new AudioStream(in);
			//AudioPlayer.player.start(as);
		} catch(IOException e) {
			System.out.println("Can't Find The File");
		}
	}
}


