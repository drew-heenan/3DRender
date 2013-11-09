package engine;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Display extends JFrame{
	
	private static boolean closeRequested = false;
	private static Display inst;

	public Display(){
		inst = this;
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		new InputListener(this);
		InputListener.registerListener(this, InputType.WINDOW_CLOSING);
	}
	
	
	//Listeners
	public void windowClosing(WindowEvent e){
		Log.say(LogLevel.DEBUG, "Close requested.");
		closeRequested = true;
	}
	
	//Static Methods
	
	public static boolean isCloseRequested(){
		return closeRequested;
	}
	
	public static void requestClose(){
		closeRequested = true;
	}
	
	public static Display getRealInstance(){
		return inst;
	}
	
	public static void render(){
		getRealInstance().repaint();
	}
}
