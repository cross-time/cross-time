package fr.EngineLWJGL.Engine.Game;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import fr.EngineLWJGL.Engine.Graphic.Input;
import fr.EngineLWJGL.Engine.Graphic.Render;
import fr.EngineLWJGL.Engine.Graphic.RenderTools;

public class Game 
{
	float tr;
	public Game()
	{
		tr = 0;
	}
	
	public void input()
	{
		if(Input.isKeyDown(Input.KEY_ESCAPE))
			System.out.println("Escape pressed");
		if(Input.isKeyDown(Input.KEY_A))
			System.out.println("A pressed");
	}
	
	public void update()
	{
		this.tr += 1;
	}
	
	public void render()
	{
		RenderTools.clear();
		GL11.glLoadIdentity();
		GL11.glOrtho(0.0, Display.getDisplayMode().getWidth(), 0.0, Display.getDisplayMode().getHeight(), -1.0, 1.0);
		/*GL11.glLoadIdentity();
		GL11.glOrtho(0.0, Display.getDisplayMode().getWidth(), 0.0, Display.getDisplayMode().getHeight(), -1.0, 1.0);
		GL11.glTranslatef(0f, tr, 0.f);

		GL11.glBegin(GL11.GL_TRIANGLES);
			RenderUtil.colorRGB(Color.BLUE);
			GL11.glVertex2i(200, Display.getDisplayMode().getHeight()/2);
			RenderUtil.colorRGB(Color.BLUE);
			GL11.glVertex2i(Display.getDisplayMode().getWidth()/2, Display.getDisplayMode().getHeight()/2-100);
			RenderUtil.colorRGB(Color.BLUE);
			GL11.glVertex2i(Display.getDisplayMode().getWidth()-200, Display.getDisplayMode().getHeight()/2);
		GL11.glEnd();*/
		
		Render.render[1].render();
		GL11.glTranslatef(0f, 200f, 0.f);
		Render.render[1].render();
		//r.render();
	}
}
