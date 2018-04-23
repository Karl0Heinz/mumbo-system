package game.objects;

import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Ball extends GameObject{

	private int circumference;
	
	public Ball() {
		posX = (MAX_POS_X - MIN_POS_X) / 2;
		posY = (MAX_POS_Y - MIN_POS_Y) / 2;
		circumference = 30;
		velX = (int) ((2.0 * Math.rint((Math.random()))) - 1.0);
		velY = (int) ((2.0 * Math.rint((Math.random()))) - 1.0);
		clip = new Ellipse2D.Float(posX, posY, circumference, circumference);
	}
	
	public void move() {
		int newPosX = posX + velX;
		if(newPosX > (MAX_POS_X - circumference)) {
			newPosX = (MAX_POS_X - circumference);
			velX *= -1;
		}
		if(newPosX < MIN_POS_X) {
			newPosX = MIN_POS_X;
			velX *= -1;
		}
		posX = newPosX;
		
		int newPosY = posY + velY;
		if(newPosY > MAX_POS_Y) {
			newPosY = MAX_POS_Y;
			velY *= -1;
		}
		if(newPosY < MIN_POS_Y) {
			newPosY = MIN_POS_Y;
			velY *= -1;
		}
		posY = newPosY;
		
		((Ellipse2D) clip).setFrame(newPosX, newPosY, circumference, circumference);
		
//		Ellipse2D test = new Ellipse2D.Float();
//		test.setFrame(newPosX, newPosY, circumference, circumference);
	}

	@Override
	public int getPosX() {
		return posX;
	}

	@Override
	public int getPosY() {
		return posY;
	}

	public int getCircumference() {
		return circumference;
	}
	
	public void setVelocity(int x, int y) {
		velX = x;
		velY = y;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}
	
}
