package engine;

public class Log {
	//TODO: Check for enabled console window; if so, print into there
	
	public static void say(LogLevel lvl, Object message){
		//TODO
		System.out.println("[" + lvl + "] : " + message);
	}
	
	public static void say(Object message){
		say(LogLevel.DEBUG, message);
	}
	
	public static void setVisible(boolean visible){
		
	}

}
