package fr.EngineLWJGL.Engine.Game.Render;

import org.lwjgl.opengl.GL11;

import fr.EngineLWJGL.Engine.Graphic.Input;
import fr.EngineLWJGL.Engine.Tools.Vector3f;


public class Camera {
	private Vector3f pos = null, eye = null;
	private int rotY = 0;
	
	public Camera() {
		pos = new Vector3f(0, 0, 0);
		eye = new Vector3f(0, 0, 1);
	}
	
	public float getPosX(){
		return pos.getX();
	}
	
	public float getPosY(){
		return pos.getY();
	}
	
	public float getPosZ(){
		return pos.getZ();
	}
	
	public float getExeX(){
		return eye.getX();
	}
	
	public float getEyeY(){
		return eye.getY();
	}
	
	public float getEyeZ(){
		return eye.getZ();
	}
	
	public void update(){
		GL11.glRotated(-rotY, 0, 1, 0);
		if(Input.isKeyDown(Input.KEY_RIGHT)){
			pos.add(-1,0,0);
			eye.add(-1,0,0);
		}
		if(Input.isKeyDown(Input.KEY_LEFT)){
			pos.add(1,0,0);
			eye.add(1,0,0);
		}
		if(Input.isKeyDown(Input.KEY_UP)){
			pos.add(0,0,1);
			eye.add(0,0,1);
		}
		if(Input.isKeyDown(Input.KEY_DOWN)){
			pos.add(0,0,-1);
			eye.add(0,0,-1);
		}
		if(Input.isKeyDown(Input.KEY_LCONTROL)){
			pos.add(0,1,-1);
		}
		if(Input.isKeyDown(Input.KEY_LSHIFT)){
			pos.add(0,-1,1);
		}
		if(Input.isKeyDown(Input.KEY_A)){
			rotY += 45; 
		}
		if(Input.isKeyDown(Input.KEY_E)){
			rotY -= 45; 
		}
		if(rotY == 360)
			rotY = 0;
		GL11.glRotated(rotY, 0, 1, 0);
	}
}
