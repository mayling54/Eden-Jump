package gamelogic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import gameengine.graphics.MyGraphics;
import gameengine.input.KeyboardInputManager;
import gameengine.maths.Vector2D;

public class ScreenTransition {

	private boolean isActive = false;
	private boolean isActivating = false;
	private boolean isDeactivating = false;
	private Vector2D position;
	private int width;
	private int height;
	private float velocity = Main.SCREEN_WIDTH * 1.5f;

	private String text[];
	private Rectangle textBox[];
	private Font font = new Font("Arial", Font.BOLD, 200);

	private List<ScreenTransitionListener> listeners = new ArrayList<>();

	public ScreenTransition() {
		this.position = new Vector2D(-Main.SCREEN_WIDTH, 0);
		this.width = Main.SCREEN_WIDTH;
		this.height = Main.SCREEN_HEIGHT;

		text = new String[2];

		textBox = new Rectangle[2];
		textBox[0] = new Rectangle(0, 100, Main.SCREEN_WIDTH, 200);
		textBox[1] = new Rectangle(0, 400, Main.SCREEN_WIDTH, 200);
	}

	public void update(float tslf) {
		if(isActive) {
			//Activating
			if(isActivating) {
				position.x += velocity * tslf;
				if(0 < position.x) {
					position.x = 0;
					isActivating = false;
					throwTransitionActivationFinishedEvent();
				}
			}
			//Deactivating
			else if(isDeactivating) {
				position.x += velocity * tslf;
				if(Main.SCREEN_WIDTH < position.x) {
					position.x = -Main.SCREEN_WIDTH;

					isDeactivating = false;
					isActive = false;
					throwTransitionFinishedEvent();
				}
			}
			else {
				if(KeyboardInputManager.isKeyDown(KeyEvent.VK_SPACE)) deactivate();;
			}
		}
	}

	public void draw(Graphics g) {
		if(isActive) {
			g.translate((int)position.x, (int)position.y);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, (int)width, (int)height);

			if(text != null) {
				g.setColor(Color.WHITE);

				for (int i = 0; i < text.length; i++) {
					MyGraphics.drawCenteredString(g, text[i], textBox[i], font);
				}
			}
			
			g.translate((int)-position.x, (int)-position.y);
		}
	}

	public void activate() {
		position.x = -Main.SCREEN_WIDTH;
		isActive = true;
		isActivating = true;
		isDeactivating = false;
	}

	public void deactivate() {
		isDeactivating = true;
	}

	public void showLoseScreen(int numberOfTries) {
		text[0] = "LOSE";
		text[1] = "TRY: " + numberOfTries;
		activate();
	}

	public void showVictorySceen(float finishTime) {
		text[0] = "WIN";
		text[1] = "TIME: " + String.format("%1.2f", finishTime/1000);
		activate();
	}

	//------------------------Listener
	public void throwTransitionActivationFinishedEvent() {
		for (ScreenTransitionListener screenTransitionListener : listeners) {
			screenTransitionListener.onTransitionActivationFinished();
		}
	}

	public void throwTransitionFinishedEvent() {
		for (ScreenTransitionListener screenTransitionListener : listeners) {
			screenTransitionListener.onTransitionFinished();
		}
	}

	public void addScreenTransitionListener(ScreenTransitionListener listener) {
		listeners.add(listener);
	}
}
