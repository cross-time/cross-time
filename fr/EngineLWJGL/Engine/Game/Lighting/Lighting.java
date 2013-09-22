package fr.EngineLWJGL.Engine.Game.Lighting;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Lighting
{
	public void Lighting()
	{
		
	}
	
	public void start()
	{
		init();
	}
	
	public void init()
	{
		FloatBuffer matSpecular = BufferUtils.createFloatBuffer(4); 
        matSpecular.put(0.5f).put(0.5f).put(0.5f).put(0.5f).flip();
		
        GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_LIGHT0);
		GL11.glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, matSpecular);
		matSpecular.put(1.6f).put(1.5f).put(1.5f).put(1.5f).flip();
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, matSpecular);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glColorMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE);
	}
}
