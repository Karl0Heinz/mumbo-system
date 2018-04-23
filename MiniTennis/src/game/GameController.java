package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.objects.Ball;
import game.objects.GameObject;
import game.objects.Racket;

@SuppressWarnings("serial")
public class GameController extends JPanel {

	private InputController input;

	private Ball ball;
	private Racket player1;
	private Racket player2;

	private int speed = 10;

	public GameController() {
		input = new InputController(this);
		ball = new Ball();
		player1 = new Racket();
		player2 = new Racket(Racket.MAX_POS_X - Racket.WIDTH, ((Racket.MAX_POS_Y - Racket.MIN_POS_Y) / 2));
		setFocusable(true);
	}

	private void moveBall() {
		ball.move();
	}

	private void movePlayers() {
		player1.move();
		player2.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.fill(ball.getClip());
		graphics.fill(player1.getClip());
		graphics.fill(player2.getClip());
	}

	private void handleClip() {

		ball.setVelocity(ball.getVelX() * -1, ball.getVelY());
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		GameController game = new GameController();
		frame.add(game);
		frame.setSize(GameObject.MAX_POS_X + (game.ball.getCircumference() / 2) + 3, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.moveBall();
			game.movePlayers();
			if (game.ball.getClip().intersects((Rectangle2D) game.player1.getClip())
					|| (game.ball.getClip().intersects((Rectangle2D) game.player2.getClip()))) {
				game.handleClip();
			}
			game.repaint();
			Thread.sleep(game.speed);
		}
	}

	public Racket getPlayer() {
		return player1;
	}

	public void switchSpeed() {
		if (speed == 10) {
			speed = 100;
		} else {
			speed = 10;
		}
	}
}