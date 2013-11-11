package game;

public class CameraEntity extends ActiveEntity {

	private Location glideLoc = null;

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
		}

	}

	public void glideTo(Location loc, int ticks) {
		glideLoc = loc;
		if (loc != null)
			this.vector = new Vector((this.getLocation().getX() - loc.getX())
					/ ticks, (this.getLocation().getY() - loc.getY()) / ticks,
					(this.getLocation().getZ() - loc.getZ()) / ticks);
	}

	public boolean isGliding() {
		return glideLoc != null;
	}

}
