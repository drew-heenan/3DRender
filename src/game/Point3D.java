package game;

public class Point3D{
	
	private double x, y, z;
	
	public Point3D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getZ(){
		return z;
	}
	
	public Location toLocationRelativeTo(World w, Location loc){
		return new Location(w, x + loc.getX(), y + loc.getY(), z + loc.getZ());
	}
	
	public Location toLocation(World w){
		return new Location(w, x, y, z);
	}
	
	@Override
	public String toString(){
		return "(" + x + ", " + y + ", " + z + ")";
	}

}
