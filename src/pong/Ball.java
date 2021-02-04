package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	double xVel, yVel, x, y;
	
	public Ball() {
		x = 350;
		y = 250;
		xVel = -2;
		yVel = 1;
	}
	public void checkCollision(Paddle p1, Paddle p2) {
		if (x <= 50) {
			if (y >= p1.getY() && y <= p1.getY() + 80) {
				xVel = -xVel; //this is where I would have the gradual speed increase, count points, etc
			}
		} else if (x >= 650) {
			if (y >= p2.getY() && y <= p2.getY() + 80) {
				xVel = -xVel; //this is where I would have the gradual speed increase, count points, etc
			}
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x - 10, (int)y - 10, 20, 20);
	}
	public void move() {
		x += xVel;
		y += yVel;
		if (y < 10 || y > 490) {
			yVel = -yVel;
		}
	}
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
}
