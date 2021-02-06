package pong;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle{
	double y, yVel;
	boolean upAccel, downAccel;
	final double GRAVITY = 0.74;
	int player, x;
	
	public HumanPaddle (int player) {
		upAccel = false;
		downAccel = false;
		y = 210;
		yVel = 0;
		if (player == 1) {
			x = 20;
		} else {
			x = 660;
		}
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, (int)y, 20, 80);
		
	}

	public void move() {
		if (upAccel) {
			yVel -= 2; // change this number to increase or decrease paddle speed
		} else if (downAccel) {
			yVel += 2; 

		} else if (!upAccel && !downAccel) {
			yVel *= GRAVITY; // change gravity to affect slowdown
		}
		if (yVel >= 5) { // these set a speed limit
			yVel = 5;
		} else if (yVel <= -5) {
			yVel = -5;
		}
		y += yVel;
		if (y < 0) { // keeps the paddles on the page
			y = 0;
		} else if (y > 420) { // 500 height - 80 paddle height
			y = 420;
		}
	}
	
	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	public int getY() {
		return (int)y;
	}

}
