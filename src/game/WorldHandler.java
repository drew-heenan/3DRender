package game;

import java.io.File;
import java.util.ArrayList;

public class WorldHandler {
	
	private static ArrayList<World> worlds = new ArrayList<World>();
	
	public static void save(World w){
		//TODO
	}
	
	public static World load(File location){
		return null; //TODO: Load world. Save the normal file location in the hashmap
	}
	
	public static World create(String name){
		World w = new World(name);
		worlds.add(w);
		return w;
	}
	
	public static ArrayList<World> getWorlds(){
		return worlds;
	}
	
	public static World getWorld(String name){
		for(World w : worlds){
			if(w.getName().equals(name)){
				return w;
			}
		}
	}

}
