package fr.EngineLWJGL.Engine.Game.Render;

import org.lwjgl.opengl.GL11;

import fr.EngineLWJGL.Engine.Tools.Color;

public class RenderTools 
{
	public RenderTools()
	{
		
	}
	
	public static void clearColor(Color color)
	{
		GL11.glClearColor((float)(color.getR()/255), (float)(color.getG()/255), (float)(color.getB()/255), 1.0F);
	}
	
	public static void clear()
	{
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearDepth(1.0f);
	}
	
	public static void colorRGB(Color color)
	{
		GL11.glColor3d(color.getR(), color.getG(), color.getB());
	}
	
	public static void colorRGB(int r, int g, int b)
	{
		GL11.glColor3d(r/255d, g/255d, b/255d);
	}
}
