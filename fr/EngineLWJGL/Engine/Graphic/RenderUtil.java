package fr.EngineLWJGL.Engine.Graphic;

import org.lwjgl.opengl.GL11;

import fr.EngineLWJGL.Engine.Utils.Color;

public class RenderUtil 
{
	public RenderUtil()
	{
		
	}
	
	public static void clearColor(Color color)
	{
		GL11.glClearColor((float)(color.getR()/255), (float)(color.getG()/255), (float)(color.getB()/255), 1.0F);
	}
	
	public static void clear()
	{
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	public static void colorRGB(Color color)
	{
		GL11.glColor3d(color.getR(), color.getG(), color.getB());
	}
}
