package engine;

import game.CameraEntity;
import game.Location;

public class GameView extends View{
	
	private CameraEntity camera;
	
	public GameView(Location cameraLoc){
		this.camera = (CameraEntity) cameraLoc.getWorld().addEntity(CameraEntity.class, cameraLoc);
		repaint();
	}
	
	public CameraEntity getCamera(){
		return camera;
	}
	
	public void setCamera(Location loc){
		this.camera.moveTo(loc);
	}

}
