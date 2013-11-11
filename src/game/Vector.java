package game;

public class Vector {
	
	private double x, y, z;
	
	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void update(ActiveEntity e){
		ForceSet f = e.getForceSet();
		//Y Speed
		if(Math.abs(y) <= f.getTerminalVelocity()){
			y -= f.getAccelerationDueToGravity();
		}
		if(y < -f.getTerminalVelocity())
			y = -f.getTerminalVelocity();
		else if(y > f.getTerminalVelocity())
			y = f.getTerminalVelocity();
		//X and Z Speed
		if(x > 0)
			x -= f.getResistance();
		else if(x < 0)
			x += f.getResistance();
		if(z > 0)
			z -= f.getResistance();
		else if(z < 0)
			z += f.getResistance();
		
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
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setZ(double z){
		this.z = z;
	}
	
	public void set(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

}
