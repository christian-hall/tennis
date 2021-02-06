package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {
	final int WIDTH = 700, HEIGHT = 550;
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	int score = 0;
	boolean gameOver = false;
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		p2 = new AIPaddle(2, b1);
		b1 = new Ball();
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.darkGray);
		g.fillRect(0, 501, WIDTH, 49);
		if (b1.getX() < -10 || b1.getX() > 710) {
			g.setColor(Color.red);
			g.drawString("GAME OVER   -  SCORE: " + score, 250, 200);
			gameOver = true;
		} else {
			p1.draw(g);
			b1.draw(g);
			p2.draw(g);
			g.setColor(Color.green);
			g.drawString("SCORE: " + score, 20, 525);
		}
		
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		for (;;) {
			if (gameOver == false) {
				p1.move();
				p2.move(b1.getY());
				b1.move();
				score = b1.checkCollision(p1, p2, score);
				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				repaint();
			}
		}

		
	}
	// add another two e.getKeyCode() == to different keys for two players
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
