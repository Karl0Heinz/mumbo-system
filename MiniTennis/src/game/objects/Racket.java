package game.objects;

import java.awt.geom.Rectangle2D;

@SuppressWarnings("serial")
public class Racket extends GameObject{
	
	private static final int BORDER = 5;

	public static final int MAX_POS_X = GameObject.MAX_POS_X - BORDER;
	public static final int MIN_POS_X = GameObject.MIN_POS_X + BORDER;
	public static final int MAX_POS_Y = GameObject.MAX_POS_Y - BORDER;
	public static final int MIN_POS_Y = GameObject.MIN_POS_Y + BORDER;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 50;
	
	public Racket() {
		this(MIN_POS_X, ((MAX_POS_Y - MIN_POS_Y) / 2));
	}
	
	public Racket(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.velX = 0;
		this.velY = 0;
		this.clip = new Rectangle2D.Float(posX, posY, WIDTH, HEIGHT);
	}
	
	public void move() {
		int newPosY = posY + velY;
		if(newPosY > MAX_POS_Y) {
			newPosY = MAX_POS_Y;
//			Rectangle2D test = new Rectangle2D.Float();
//			test.setRect(posX, MAX_POS_Y, w, h);
		}
		if(newPosY < MIN_POS_Y) {
			newPosY = MIN_POS_Y;
		}
		posY = newPosY;
		((Rectangle2D) clip).setRect(posX, newPosY, WIDTH, HEIGHT);
	}
	
	public void setVelocity(int y) {
		velY = y;
	}

}
