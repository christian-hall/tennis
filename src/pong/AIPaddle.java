package pong;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle{
	double y, yVel;
	boolean upAccel, downAccel;
	final double GRAVITY = 0.94;
	int player, x;
	Ball b1;
	
	public AIPaddle (int player, Ball b) {
		upAccel = false;
		downAccel = false;
		b1 = b;
		y = 210;
		yVel = 0;
		if (player == 1) {
			x = 20;
		} else {
			x = 660;
		}
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, (int)y, 20, 80);
		
	}

	public void move(int ball_y) {
		y = ball_y - 40;
		if (y < 0) { // keeps the paddles on the page
			y = 0;
		} else if (y > 420) { // 500 height - 80 paddle height
			y = 420;
		}
	}

	public int getY() {
		return (int)y;
	}

	@Override
	public void move() {		
	}

}
