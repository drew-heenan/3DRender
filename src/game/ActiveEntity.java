package game;

public abstract class ActiveEntity extends Entity{
	
	protected ForceSet forces = null;
	protected Vector vector = new Vector(0, 0, 0);

	public ActiveEntity(Location loc) {
		super(loc);
	}
	
	public abstract void update();
	
	protected void updatePosition(){
		System.out.println(vector);
		this.loc.set(loc.getX() + vector.getX(), loc.getY() + vector.getY(), loc.getZ() + vector.getZ());
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
