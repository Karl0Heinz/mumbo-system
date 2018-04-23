package game.objects;

import java.awt.Shape;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GameObject extends JPanel{

	public static final int MAX_POS_X = 250;
	public static final int MIN_POS_X = 0;
	public static final int MAX_POS_Y = 123;
	public static final int MIN_POS_Y = 0;
	
	protected int posX;
	protected int posY;
	protected int velX;
	protected int velY;
	
	protected Shape clip;
	
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	
	public void setClip(Shape clip) {
		this.clip = clip;
	}
	
	public Shape getClip() {
		return clip;
	}
}
