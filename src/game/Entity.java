package game;

public abstract class Entity {
	
	protected boolean visible = true;
	protected Location loc;
	protected Model model;
	
	public Entity(Location loc){
		this.loc = loc;
	}

}
