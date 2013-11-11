package game;


public abstract class Entity {
	
	protected boolean visible = true;
	protected Location loc;
	//protected HashMap<String, Model> modelSet = new HashMap<String, Model>();
	//TODO: My Model system will not work. I require Models with built-in function animations for different actions (movement, death, etc)

	public Entity(Location loc){
		this.loc = loc;
	}
	
	
	public Location getLocation(){
		return loc;
	}
	
	public World getWorld(){
		return loc.getWorld();
	}
	
	public void moveTo(Location loc){
		this.loc = loc;
	}
	
//	public HashMap<String, Model> getModelSet(){
//		return modelSet;
//	}
//	
//	public void setModel(HashMap<String, Model> m){
//		modelSet = m;
//	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public void remove(){
		getWorld().removeEntity(this);
	}

}
