package game;

import engine.Log;

public class CameraEntity extends ActiveEntity {

	private Location glideLoc = null;
	private int glideTicks = 1;

	public CameraEntity(Location loc) {
		super(loc);
		this.visible = false;
		this.forces = new ForceSet(0, 0, 0);
	}

	@Override
	public void update() {
		if (glideLoc != null) {
			Vector v = this.getVector();
			updatePosition();
			this.vector = v;
			this.vector.set((glideLoc.getX() - this.loc.getX())/glideTicks, (glideLoc.getY() - this.loc.getY())/glideTicks, (glideLoc.getZ() - this.loc.getZ())/glideTicks);
			Log.say("UPDATING CAMERA ENTITY");
			glideTicks --;
		}
		if(glideTicks == 0){
			this.vector.set(0, 0, 0);
			moveTo(glideLoc);
			this.glideLoc = null;
			glideTicks = 1;
		}

	}

	public void glideTo(Location loc, int ticks) {
		if(ticks != 0){
			glideTicks = ticks;
			glideLoc = loc;
			if (loc != null)
				this.vector.set((loc.getX() - this.loc.getX())/ticks, (loc.getY() - this.loc.getY())/ticks, (loc.getZ() - this.loc.getZ())/ticks);
		}
	}

	public boolean isGliding() {
		return glideLoc != null;
	}

}
