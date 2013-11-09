package game;

public abstract class ActiveEntity extends Entity{

	public ActiveEntity(Location loc) {
		super(loc);
		
	}
	
	public abstract void update();

}
