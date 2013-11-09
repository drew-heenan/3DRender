package engine;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.DebugGraphics;
import javax.swing.JFrame;

public class InputListener implements MouseListener, MouseWheelListener, MouseMotionListener, KeyListener, WindowListener{
	
	private static HashMap<InputType, ArrayList<Object>> targets = new HashMap<InputType, ArrayList<Object>>();
	private static HashMap<Integer, Boolean> pressedKeys = new HashMap<Integer, Boolean>();
	
	private static boolean isLeftDown = false;
	private static boolean isRightDown = false;
	private static boolean isMiddleDown = false;
	private static Point mousePos = new Point(0, 0);
	
	public InputListener(JFrame parent){
		parent.addMouseListener(this);
		parent.addMouseWheelListener(this);
		parent.addKeyListener(this);
		parent.addWindowListener(this);
		parent.addMouseMotionListener(this);
		for(InputType t : InputType.values())
			targets.put(t, new ArrayList<Object>());
	}
	
	//Static Methods
	public static boolean registerListener(Object reciever, InputType type){
		ArrayList<Object> trgts = targets.get(type);
		if(trgts == null)
			trgts = new ArrayList<Object>();
		if(!trgts.contains(reciever)){
			trgts.add(reciever);
			targets.put(type, trgts);
			return true;
		}
		return false;
		
	}
	
	public static boolean unregisterListeners(Object reciever){
		boolean found = false;
		for(InputType t : InputType.values()){
			if(targets.get(t).contains(reciever)){
				targets.get(t).remove(reciever);
				found = true;
			}
		}
		return found;
	}
	
	public static boolean unregisterListener(Object reciever, InputType type){
		return targets.get(type).remove(reciever);
	}
	
	public static boolean isUsed(Integer key){
		return pressedKeys.get(key);
	}
	
	public static void setUsed(Integer key){
		if(pressedKeys.containsKey(key))
			pressedKeys.put(key, true);
	}
	
	public static boolean isPressed(Integer key){
		return pressedKeys.containsKey(key);
	}
	
	public static Set<Integer> getPressedKeys(){
		return pressedKeys.keySet();
	}
	
	public static boolean isRightMouseDown(){
		return isRightDown;
	}
	
	public static boolean isLeftMouseDown(){
		return isLeftDown;
	}
	
	public static boolean isMiddleMouseDown(){
		return isMiddleDown;
	}
	
	public static Point getMousePosition(){
		return mousePos;
	}
	
	
	//EVENTS

	@Override
	public void windowActivated(WindowEvent e) {
		InputType t = InputType.WINDOW_ACTIVATED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("windowActivated", WindowEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		InputType t = InputType.WINDOW_CLOSED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("windowClosed", WindowEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		InputType t = InputType.WINDOW_CLOSING;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("windowClosing", WindowEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		InputType t = InputType.WINDOW_DEACTIVATED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("windowDeactivated", WindowEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		InputType t = InputType.WINDOW_DEICONIFIED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("windowDeiconified", WindowEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		InputType t = InputType.WINDOW_ICONIFIED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("windowIconified", WindowEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		InputType t = InputType.WINDOW_OPENED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("windowActivated", WindowEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		InputType t = InputType.KEY_PRESSED;
		if(pressedKeys.containsKey(e.getKeyCode()))
			pressedKeys.put(e.getKeyCode(), true);
		else
			pressedKeys.put(e.getKeyCode(), false);
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("keyPressed", KeyEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		Log.say(e.getKeyCode() + " : " + pressedKeys.get(e.getKeyCode()));
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		InputType t = InputType.KEY_RELEASED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("keyReleased", KeyEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		pressedKeys.remove(e.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		InputType t = InputType.KEY_TYPED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("keyTyped", KeyEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		InputType t = InputType.MOUSE_WHEEL_MOVED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mouseWheelMoved", MouseWheelEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		InputType t = InputType.MOUSE_CLICKED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mouseClicked", MouseEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
		if (e.getClickCount() == 2) 
		    mouseDoubleClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		InputType t = InputType.MOUSE_ENTERED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mouseEntered", MouseEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		InputType t = InputType.MOUSE_EXITED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mouseExited", MouseEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		InputType t = InputType.MOUSE_PRESSED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mousePressed", MouseEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		if(e.getButton() == MouseEvent.BUTTON1)
			isLeftDown = true;
		else if(e.getButton() == MouseEvent.BUTTON2)
			isMiddleDown = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			isRightDown = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		InputType t = InputType.MOUSE_RELEASED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mouseReleased", MouseEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		if(e.getButton() == MouseEvent.BUTTON1)
			isLeftDown = false;
		else if(e.getButton() == MouseEvent.BUTTON2)
			isMiddleDown = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			isRightDown = false;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		InputType t = InputType.MOUSE_DRAGGED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mouseDragged", MouseEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		InputType t = InputType.MOUSE_MOVED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mouseMoved", MouseEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		mousePos.setLocation(e.getX(), e.getY());
		
	}
	
	public void mouseDoubleClicked(MouseEvent e){
		InputType t = InputType.MOUSE_DOUBLE_CLICKED;
		for(Object o : targets.get(t)){
			try {
				o.getClass().getMethod("mouseDoubleClicked", MouseEvent.class).invoke(o, e);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException e1) {
				Log.say(LogLevel.ERROR, "Could not find a proper " + t + " method in " + o );
				e1.printStackTrace();
			}
		}
		
	}

}
