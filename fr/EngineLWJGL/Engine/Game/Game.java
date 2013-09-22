package fr.EngineLWJGL.Engine.Game;

import java.nio.FloatBuffer;


import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import fr.EngineLWJGL.Engine.Game.Lighting.Lighting;
import fr.EngineLWJGL.Engine.Game.Render.Render;
import fr.EngineLWJGL.Engine.Game.Render.RenderTools;
import fr.EngineLWJGL.Engine.Graphic.Input;

public class Game 
{
	float tr;
	Lighting light = null;
	
	public Game()
	{
		tr = 0;
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
	    GL11.glLoadIdentity();
	    GLU.gluPerspective(70,(float)Display.getWidth()/Display.getHeight(),1,1000);
	    GL11.glEnable(GL11.GL_DEPTH_TEST);
	    //GL11.glPolygonMode (GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
	    GL11.glEnable(GL11.GL_SMOOTH);
	    //GL11.glMatrixMode(GL11.GL_MODELVIEW);
	    light = new Lighting();
	    light.start();
	}
	
	public static void func()
	{
		GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
	    System.out.println("Resize");
	}
	
	public void input()
	{
		if(Input.isKeyDown(Input.KEY_ESCAPE))
			System.out.println("Escape pressed");
		if(Input.isKeyDown(Input.KEY_A))
			System.out.println("A pressed");
		
		//Render.render[2].input();
	}
	
	public void update()
	{
		this.tr += 1;
	}
	
	public void render()
	{
		RenderTools.clear();
			
		
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	    GL11.glLoadIdentity();
	 
	    GLU.gluLookAt(8,10,8,2,0,2,0,1,0);
		
		RenderTools.colorRGB(75, 255, 255);
		
		//Render.render[3].render();
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 2, 0);
		RenderTools.colorRGB(30, 30, 30);
		Render.render[2].render();
		GL11.glPopMatrix();
		
		GL11.glFlush();
	}
}
