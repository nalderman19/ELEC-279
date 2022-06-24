/* Nicholas Alderman and Jacob Young's Wild West Gold Thief!
 * Made in September - October 2014 for FY Computer Science*/

package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Random;

//import sun.audio.*;


public class MyCanvas extends Canvas {
	//this variable counts how many steps you have taken
	int movecount = 0;
	//this one lets me easily change the image of link moving
	String imgName = "link.png";
	String goldimg = "gold.png";
	String guardimg = "guard.png";
	Image link = Toolkit.getDefaultToolkit().getImage("stuff/" + imgName);
	Image gold = Toolkit.getDefaultToolkit().getImage("stuff/" + goldimg);
	Image guard = Toolkit.getDefaultToolkit().getImage("stuff/" + guardimg);
	Rectangle[] badguys = new Rectangle[10];
	Rectangle rectang = new Rectangle(370, 280, 30, 30);
		
	
	
	
	int myX = 100; int myY = 100; int linkX = 30; int linkY = 30;
	public MyCanvas() {
		this.setSize(600, 600);
		
		badguys = this.makeArray(badguys, 0, 450);
		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				moveIt(evt);
			}}
			);
	}
	
	private Rectangle[] makeArray(Rectangle[]badguys,int min, int max) {
		//this for loop gives the bad guys their absolutely random locations
		for (int i = 0; i < badguys.length;i++)  {
			Random rand = new Random();
			int randomX = rand.nextInt((max - min) + 1) + min;
			int randomY = rand.nextInt((max - min) + 1) + min;
			badguys[i] = new Rectangle(randomX,randomY,50,50);
			
		}
		return badguys;
		
	}
	
	
	public void moveIt (KeyEvent evt) {
		//this for loop is for detecting collisions with the red, bad guy blocks
		for (int i = 0; i < badguys.length; i++) {
			if (badguys[i].intersects(myX,myY,15,15)) {
				linkY = 35;
				linkX = 45; 
				imgName = "dead.png";
				MyScreen.playIt("caught.wav");
				repaint();
				return;
			}
			}
		//this one keeps your character inside the window
		if (myY < 10) {myY += 10;}
		if (myX < 10) {myX += 10;}
		if (myY > 540) {myY -= 10;}
		if (myX > 550) {myX -= 10;}
						
	switch (evt.getKeyCode()) {
	//Every time you press a key, the computer comes here to see what to do
		case KeyEvent.VK_DOWN:
			movecount = movecount + 1;
			linkY = 30;
			linkX =30;
			myY += 5;
			if (imgName == "forward.png") {
				imgName = "forward2.png";
			} else imgName = "forward.png"; {
				myY += 5;
			repaint();
			break;}
		case KeyEvent.VK_UP:
			movecount = movecount + 1;
			linkY = 30;
			linkX =30;
			myY -= 5; 
			if (imgName == "back.png") {
				imgName = "back2.png";
			} else imgName = "back.png"; {
				myY -= 5;
			repaint();
			break;}
		case KeyEvent.VK_LEFT:
			movecount = movecount + 1;
			linkY = 30;
			linkX =30;
			myX -= 5;
			if (imgName == "left.png") {
				imgName = "left2.png";
			} else imgName = "left.png"; {
				myX -= 5;
			repaint();
			break;}
		case KeyEvent.VK_RIGHT:
			movecount = movecount + 1;
			linkY = 30;
			linkX =30;
			myX += 5;
			if (imgName == "right.png") {
				imgName = "right2.png";
			} else imgName = "right.png"; {
				myX += 5;
			repaint();
			break;}
		case KeyEvent.VK_SPACE:
			linkX = 45;
			linkY = 35;
			imgName = "righta.png";
			repaint();
			MyScreen.playIt("swing.wav");
			break;
		case KeyEvent.VK_R:
			myX = 50;
			myY = 50;
			imgName = "link.png";
			repaint();
			break;
	}
	}
	
	public void paint(Graphics g) {
		//you display all the images on the canvas here
		link = Toolkit.getDefaultToolkit().getImage("stuff/" + imgName);
		gold = Toolkit.getDefaultToolkit().getImage("stuff/" + goldimg);
		g.drawImage(link, myX, myY, linkX, linkY, this);
		g.setColor(Color.YELLOW);
		g.drawString("COLLECT THE GOLD TO WIN", 5, 15);
		g.drawImage(gold, 500, 500, 55, 55, this);
		for (int i = 0; i < badguys.length; i++) {
			g.drawImage(guard, badguys[i].x, badguys[i].y, badguys[i].width, badguys[i].height, this);
			if (movecount > 5) {
				g.setColor(Color.DARK_GRAY);
				g.fillRect(500, 500, 55, 55);
				g.clearRect(badguys[i].x, badguys[i].y, badguys[i].width, badguys[i].height);
			} if (movecount == 15) {
				movecount = 0;
	}}
		if (rectang.intersects(myX,myY,linkX,linkY)) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.YELLOW);
			g.drawString("YOU WIN!!!", 100, 100);
			MyScreen.playIt("win.wav");
		}
		if (imgName == "dead.png") {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.YELLOW);
			g.drawString("YOU LOSE!!!", 100, 100);
		}
	}}
			
