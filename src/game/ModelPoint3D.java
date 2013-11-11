package game;

import javax.vecmath.Point3d;

@SuppressWarnings("serial")
public class ModelPoint3D extends Point3d{
	
	public Location toLocationRelativeTo(World w, Location loc){
		return new Location(w, x + loc.getX(), y + loc.getY(), z + loc.getZ());
	}
	
	public Location toLocation(World w){
		return new Location(w, x, y, z);
	}

}
