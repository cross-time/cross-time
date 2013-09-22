package fr.EngineLWJGL.Engine.Game.Render;

import org.lwjgl.opengl.GL11;

import fr.EngineLWJGL.Engine.Tools.Color;


public class RenderMap extends Render
{
	private int id;
	public RenderMap(int id)
	{
		super(id);
		this.id = id;
	}
	
	public void intput()
	{
	}

	public void update()
	{
	}

	public void render()
	{
		GL11.glNewList(this.id, GL11.GL_COMPILE);
		RenderTools.colorRGB(Color.RED);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex3i(0, 0, 0);
			GL11.glVertex3i(10, 0, 0);
			GL11.glVertex3i(10, 0, 10);
			GL11.glVertex3i(0, 0, 10);
			
			GL11.glVertex3i(0, 0, 10);
			GL11.glVertex3i(10, 0, 10);
			GL11.glVertex3i(10, 10, 10);
			GL11.glVertex3i(0, 10, 10);
		GL11.glEnd();
		GL11.glEndList();
	}

}
