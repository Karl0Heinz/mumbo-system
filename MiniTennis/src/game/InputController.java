package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class InputController {
	
	GameController game;
	
	ArrayList<String> keys;
	
	public InputController(GameController game) {
		this.game = game;
		keys = new ArrayList<>();
		
		KeyListener listener = new MyKeyListener();
		game.addKeyListener(listener);
	}

//	InputController keyboardExample = new InputController();
//	frame.add(keyboardExample);
	
	private void handleKeyPress(String key) {
		switch (key) {
			case "Oben": 		if(!(keys.contains(key))) 
									keys.add(key);
								game.getPlayer().setVelocity(-1);
								break;
			case "Unten": 		if(!(keys.contains(key))) 
									keys.add(key);
								game.getPlayer().setVelocity(1);
								break;
			case "Leertaste" : 	game.switchSpeed();
								break;
		}
//		System.out.println("keyPressed=" + key);
	}
	
	private void handleKeyRelease(String key) {
		switch (key) {
			case "Oben":	keys.remove(key);
							if(keys.contains("Unten"))
								game.getPlayer().setVelocity(1);
							else
								game.getPlayer().setVelocity(0);
							break;
			case "Unten": 	keys.remove(key);
							if(keys.contains("Oben"))
								game.getPlayer().setVelocity(-1);
							else
								game.getPlayer().setVelocity(0);
							break;
		}
//		System.out.println("keyReleased=" + key);
	}
	
	public class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			handleKeyPress(KeyEvent.getKeyText(e.getKeyCode()));
		}

		@Override
		public void keyReleased(KeyEvent e) {
			handleKeyRelease(KeyEvent.getKeyText(e.getKeyCode()));
		}
	}
}