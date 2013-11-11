package game;

public abstract class ActiveEntity extends Entity{
	
	protected ForceSet forces = null;
	protected Vector vector;

	public ActiveEntity(Location loc) {
		super(loc);
	}
	
	public abstract void update();
	
	protected void updatePosition(){
		vector.update(this);
		
	}
	
	public void setForceSet(ForceSet forces){
		this.forces = forces;
	}
	
	public ForceSet getForceSet(){
		if(forces == null)
			return loc.getWorld().getForceSet();
		else
			return forces;
	}
	
	public void setVector(Vector v){
		this.vector = v;
	}
	
	public Vector getVector(){
		return vector;
	}

}
