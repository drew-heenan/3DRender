package game;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import engine.Log;
import engine.LogLevel;

public class World {
	
	private String name;
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private ForceSet forces = new ForceSet(9.81, 5.0, 100);
	
	public World(String name){
		this.name = name;
	}
	
	public void update(){
		for(Entity e : entities)
			if(e instanceof ActiveEntity)
				((ActiveEntity)e).update();
	}
	
	
	public Entity addEntity(Class<? extends Entity> type, Location loc){
		try {
			Entity en = type.getConstructor(Location.class).newInstance(loc);
			entities.add(en);
			return en;
		} catch (IllegalArgumentException | SecurityException
				| InstantiationException | IllegalAccessException
				| InvocationTargetException | NoSuchMethodException e) {
			Log.say(LogLevel.SEVERE, "Failed to create entity " + type.getName() + " at " + loc.toString());
			e.printStackTrace();
			return null;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Entity> getEntities(){
		return entities;
	}
	
	public ForceSet getForceSet(){
		return forces;
	}
	
	public void setForceSet(ForceSet forces){
		this.forces = forces;
	}
	
	public void removeEntity(Entity e){
		entities.remove(e);
	}
	
	

}
