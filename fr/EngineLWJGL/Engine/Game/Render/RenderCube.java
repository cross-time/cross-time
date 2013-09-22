package fr.EngineLWJGL.Engine.Game.Render;

import org.lwjgl.opengl.GL11;

import fr.EngineLWJGL.Engine.Graphic.Input;

public class RenderCube extends Render
{
	int rotate;

	public RenderCube(int id, String file)
	{
		super(id, file);
		rotate = 0;
	}
	
	public void input()
	{
		if(Input.isKeyDown(Input.KEY_SPACE))
		{
			rotate += 25;
			//GL11.glPushMatrix();
				GL11.glTranslatef(0, 50, 0);
			//GL11.glPopMatrix();
			
			System.out.println("rotate");
		}
	}

}
