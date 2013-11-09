package game;

public class Location {

	private World world;
	private double x;
	private double y;
	private double z;
	private double pitch;
	private double yaw;

	public Location(World world, double x, double y, double z, double pitch, double yaw) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.yaw = yaw;
	}
	
	public Location(World world, double x, double y, double z){
		this(world, x, y, z, 0, 0);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	public double getPitch(){
		return pitch;
	}
	
	public double getYaw(){
		return yaw;
	}

	public World getWorld() {
		return world;
	}

	public double getDistance(Location l1) {
		Location l2 = this;
		return Math.sqrt(((l1.getX() - l2.getX()) * (l1.getX() - l2.getX()))
				+ ((l1.getY() - l2.getY()) * (l1.getY() - l2.getY()))
				+ ((l1.getZ() - l2.getZ()) * (l1.getZ() - l2.getZ())));
	}

}
