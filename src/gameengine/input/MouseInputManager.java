/*
 * 
 */
package gameengine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.event.MouseInputListener;

import gameengine.graphics.MyWindow;

/**
 * 
 * @author Paul Kappmeyer & Daniel Lucarz
 * 
 */

public final class MouseInputManager implements MouseInputListener, MouseWheelListener {
	
	private static boolean[] mousebutton = new boolean[5];
	private static float mouseX;
	private static float mouseY;
	
	private MyWindow window;
	
	public MouseInputManager(MyWindow window) {
		this.window = window;
	}
	
	public static boolean isButtonDown(int mouseButton) {
		if(mouseButton >= 0 && mouseButton < mousebutton.length && mousebutton[mouseButton]) return true;
		else return false;
	}
	public static float getMouseX () {
		return mouseX;
	}
	public static float getMouseY () {
		return mouseY;
	}
		
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		int button = mouseEvent.getButton();
		if(button >= 0 && button < mousebutton.length) mousebutton[button] = false;
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		int button = mouseEvent.getButton();
		if(button >= 0 && button < mousebutton.length) mousebutton[button] = true;
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		int button = mouseEvent.getButton();
		if(button >= 0 && button < mousebutton.length) mousebutton[button] = false;
	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		int button = mouseEvent.getButton();
		if(button >= 0 && button < mousebutton.length) mousebutton[button] = true;
		
		mouseX = mouseEvent.getX() - window.getInsetX();
		mouseY = mouseEvent.getY() - window.getInsetY();
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		mouseX = mouseEvent.getX() - window.getInsetX();
		mouseY = mouseEvent.getY() - window.getInsetY();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
		// TODO Auto-generated method stub
	}
}
