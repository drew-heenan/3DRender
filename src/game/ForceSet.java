package game;

public class ForceSet {
	
	private double acceleration, resist, terminal;
	
	public ForceSet(double accelerationDueToGravity, double horizontalSlowing, double terminalVelocity){
		this.acceleration = accelerationDueToGravity;
		this.resist = horizontalSlowing;
		this.terminal = terminalVelocity;
	}
	
	public double getAccelerationDueToGravity(){
		return acceleration;
	}
	
	public double getResistance(){
		return resist;
	}
	
	public double getTerminalVelocity(){
		return terminal;
	}

}
