package fr.EngineLWJGL.Engine.Game.Render;

import org.lwjgl.opengl.GL11;

import fr.EngineLWJGL.Engine.Graphic.Render;

public class RenderMap extends Render
{
	
	public RenderMap(int id)
	{
		super(id);
	}
	
	public void intput()
	{
	}

	public void update()
	{
	}

	public void render()
	{
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2i(20, 20);
			GL11.glVertex2i(200, 20);
			GL11.glVertex2i(200, 200);
			GL11.glVertex2i(20, 200);
		GL11.glEnd();
	}

}
