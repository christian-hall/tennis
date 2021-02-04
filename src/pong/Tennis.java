package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {
	final int WIDTH = 700;
	final int HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		p1 = new HumanPaddle(2);
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		p1.draw(g);
	}
	
	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		for (;;) {
			p1.move();
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
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
